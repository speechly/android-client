package com.speechly.client.speech

import android.content.Context
import com.speechly.client.cache.SharedPreferencesCache
import com.speechly.client.device.CachingIdProvider
import com.speechly.client.device.DeviceIdProvider
import com.speechly.client.identity.CachingIdentityService
import com.speechly.client.identity.IdentityService
import com.speechly.client.slu.*
import kotlinx.coroutines.flow.collect
import java.io.Closeable
import java.util.UUID

interface ContextCallback {
    fun onResponse(response: Response)
    fun onSegment(segment: Segment)
    fun onError(t: Throwable)
}

interface AudioStartCallback {
    suspend fun onAudio(audioChunk: ByteArray)
    fun onError(t: Throwable)
}

typealias AudioStopCallback = () -> Unit

interface AudioRecorder : Closeable {
    fun startRecording(callback: AudioStartCallback)
    fun stopRecording(callback: AudioStopCallback)
}

/**
 * This class represents an exception indicating that there is no active stream to interact with.
 */
class NoActiveStreamException : Throwable("No active SLU stream available")

class Client (
        private val appId: UUID,
        language: StreamConfig.LanguageCode,
        deviceIdProvider: DeviceIdProvider,
        private val identityService: IdentityService,
        private val sluService: SluService,
        private val audioRecorder: AudioRecorder,
) : Closeable {
    private val streams: MutableList<SluStream> = mutableListOf()

    private val deviceId: UUID = deviceIdProvider.getDeviceId()

    // TODO: make this configurable
    private val streamConfig = StreamConfig(
            channelCount = 1,
            sampleRateHertz = 44_000,
            languageCode = language,
    )

    companion object {
        fun fromContext(
                context: Context,
                appId: UUID,
                language: StreamConfig.LanguageCode,
                target: String = "api.speechly.com",
                secure: Boolean = true,
        ): Client {
            val cache = SharedPreferencesCache.fromContext(context)

            return Client(
                    appId,
                    language,
                    CachingIdProvider(cache),
                    CachingIdentityService.forTarget(cache, target, secure),
                    StreamingSluService.forTarget(target, secure),
                    object : AudioRecorder {
                        override fun startRecording(callback: AudioStartCallback) {
                            TODO("Not yet implemented")
                        }

                        override fun stopRecording(callback: AudioStopCallback) {
                            TODO("Not yet implemented")
                        }

                        override fun close() {
                            TODO("Not yet implemented")
                        }

                    },
            )
        }
    }

    suspend fun startContext(callback: ContextCallback) {
        val token = this.identityService.authenticate(this.appId, this.deviceId)

        try {
            val stream = this.sluService.stream(token, this.streamConfig)
            this.streams.add(stream)

            this.audioRecorder.startRecording(object : AudioStartCallback {
                override suspend fun onAudio(audioChunk: ByteArray) {
                    stream.write(audioChunk)
                }

                override fun onError(t: Throwable) {
                    callback.onError(t)
                    stream.close()
                }
            })

            stream.toFlow().collect {
                callback.onResponse(it)
            }

            stream.toSegmentFlow().collect {
                callback.onSegment(it)
            }
        } catch (t: Throwable) {
            callback.onError(t)
        }
    }

    fun stopContext() {
        this.audioRecorder.stopRecording {
            // Always stop the currently active read stream.
            val stream = this.getReadStream()

            // Start closing it and wait until its drained.
            stream.close()

            // Once drained, we can remove it from the list.
            this.streams.remove(stream)
        }
    }

    override fun close() {
        this.audioRecorder.close()
        this.sluService.close()
        this.identityService.close()
    }

    private fun getReadStream(): SluStream {
        if (this.streams.isEmpty()) {
            throw NoActiveStreamException()
        }

        // Always use the last stream for reading.
        return this.streams.last()
    }
}

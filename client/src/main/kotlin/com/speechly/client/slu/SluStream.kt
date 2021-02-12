package com.speechly.client.slu

import com.google.protobuf.ByteString
import com.speechly.api.slu.v1.SLUGrpcKt
import com.speechly.api.slu.v1.Slu.*
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import java.io.Closeable

private val startReq: SLURequest = SLURequest
        .newBuilder()
        .setEvent(
                SLUEvent
                        .newBuilder()
                        .setEvent(SLUEvent.Event.START)
                        .build()
        ).build()

private val stopReq: SLURequest = SLURequest
        .newBuilder()
        .setEvent(
                SLUEvent
                        .newBuilder()
                        .setEvent(SLUEvent.Event.STOP)
                        .build()
        ).build()

/**
 * An interface representing a single SLU stream between the client and Speechly SLU API.
 */
interface SluStream : Closeable {
    /**
     * Returns a Flow containing individual responses (transcripts, entities and intents).
     */
//    fun toFlow(): Flow<Response>

    /**
     * Returns a Flow containing segment states.
     */
//    suspend fun toSegmentFlow(): Flow<Segment>
}

/**
 * This data class represents a configuration of the audio data sent to the SLU stream.
 * It is used for configuring the recognition backend, so its important to provide accurate values here.
 *
 * @param channelCount the number of channels contained in the audio data (e.g. 1 is mono, 2 is stereo, etc.).
 * @param sampleRateHertz the sample rate of the audio, in Hertz.
 * @param languageCode the language of the audio, as BCP-47 compatible language tag.
 */
data class StreamConfig(
        val channelCount: Int,
        val sampleRateHertz: Int,
        val languageCode: LanguageCode
) {
    /**
     * This enum class represents audio languages supported by the SLU API.
     */
    enum class LanguageCode(val stringValue: String) {
        EN_US("en-US"),
        FI_FI("fi-FI")
    }
}

/**
 * This class represents an exception thrown when trying to interact with a closed stream.
 */
class StreamClosedException: Throwable("SLU stream is closed")

/**
 * A SLU stream implementation backed by Speechly gRPC SLU API.
 *
 * @param clientStub client stub for the API, with metadata attached.
 * @param streamConfig SLU configuration to use for this stream.
 * @param requestChannel (optional) channel to use for sending the audio chunks.
 * @param responseChannel (optional) channel to use for receiving responses.
 */
@ExperimentalCoroutinesApi
class GrpcSluStream(
        clientStub: SLUGrpcKt.SLUCoroutineStub,
        streamConfig: StreamConfig,
        audioFlow: Flow<ByteArray>
//        private val responseChannel: Channel<Slu.SLUResponse> = Channel()
) : SluStream {
    var responseFlow: Flow<SLUResponse>? = null
    init {
        val builder = SLURequest.newBuilder()
        val configReq = builder.setConfig(
                SLUConfig.newBuilder()
                        .setChannels(streamConfig.channelCount)
                        .setSampleRateHertz(streamConfig.sampleRateHertz)
                        .setLanguageCode(streamConfig.languageCode.stringValue)
                        .setEncoding(SLUConfig.Encoding.LINEAR16)
                        .build()
        ).build()

        val requestFlow: Flow<SLURequest> = flow {
            audioFlow.collect { chunk ->
                val audioReq: SLURequest = SLURequest.newBuilder().setAudio(ByteString.copyFrom(chunk)).build()
                emit(audioReq)
            }
        }.onStart {
            emit(configReq)
            emit(startReq)
        }.onCompletion {
            emit(stopReq)
        }

        responseFlow = clientStub.stream(requestFlow)
    }

    @ExperimentalCoroutinesApi
    override fun close() {
    }
}

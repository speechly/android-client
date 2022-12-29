package com.speechly.client.speech

import android.app.Activity
import android.content.Context
import android.media.AudioManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.speechly.api.slu.v1.SLURequest
import com.speechly.api.slu.v1.SLUResponse
import com.speechly.client.cache.SharedPreferencesCache
import com.speechly.client.device.CachingIdProvider
import com.speechly.client.device.DeviceIdProvider
import com.speechly.client.identity.CachingIdentityService
import com.speechly.client.identity.IdentityService
import com.speechly.client.slu.*
import kotlinx.coroutines.*
import java.io.Closeable
import java.util.UUID
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf

/**
 * A client for Speechly Spoken Language Understanding (SLU) API.
 * The client providing a high-level API for interacting with so-called speech segments.
 */
interface ApiClient : Closeable {
    /**
     * Starts a new SLU context by sending a start context event to the API and unmuting the microphone.
     */
    @DelicateCoroutinesApi
    @ExperimentalCoroutinesApi
    fun startContext()
    /**
     * Stops current SLU context by sending a stop context event to the API and muting the microphone
     * delayed by contextStopDelay = 250 ms
     */
    fun stopContext()
    /**
     * Adds a listener for current segment change events.
     * @param block - the callback to invoke on segment change events.
     */
    fun onSegmentChange(block: (segment: Segment) -> Unit)
    /**
     * Adds a listener for transcript responses from the API.
     * @param block - the callback to invoke on a transcript response.
     */
    fun onTranscript(block: (transcript: Transcript) -> Unit)
    /**
     * Adds a listener for tentative transcript responses from the API.
     * @param block - the callback to invoke on a tentative transcript response.
     */
    fun onTentativeTranscript(block: (transcripts: List<Transcript>) -> Unit)
    /**
     * Adds a listener for tentative entities responses from the API.
     * @param block - the callback to invoke on a tentative entities response.
     */
    fun onTentativeEntities(block: (entities: List<Entity>) -> Unit)
    /**
     * Adds a listener for entity responses from the API.
     * @param block - the callback to invoke on an entity response.
     */
    fun onEntity(block: (entity: Entity) -> Unit)
    /**
     * Adds a listener for tentative intent responses from the API.
     * @param block - the callback to invoke on a tentative intent response.
     */
    fun onTentativeIntent(block: (intent: Intent) -> Unit)
    /**
     * Adds a listener for intent responses from the API.
     * @param block - the callback to invoke on an intent response.
     */
    fun onIntent(block: (intent: Intent) -> Unit)
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
        private val sluClient: GrpcSluClient,
        private val audioRecorder: AudioRecorder,
) : ApiClient {
    private val streams: MutableList<SluStream> = mutableListOf()
    private val deviceId: UUID = deviceIdProvider.getDeviceId()
    private val coroutineScope = CoroutineScope(Job())

    init {
        GlobalScope.launch(Dispatchers.IO) {
            identityService.authenticate(appId, deviceId) // fetch token
        }
    }

    // TODO: make this configurable
    private val streamConfig = StreamConfig(
            channelCount = 1,
            sampleRateHertz = 16_000,
            languageCode = language
    )

    companion object {
        fun fromActivity(
            activity: Activity,
            appId: UUID,
            language: StreamConfig.LanguageCode = StreamConfig.LanguageCode.EN_US,
            target: String = "api.speechly.com",
            secure: Boolean = true
        ): Client {
            val audioRecorder = AudioRecorder(activity, 16000)
            val cachingIdProvider = CachingIdProvider()
            val cachingIdentityService = CachingIdentityService.forTarget(target, secure)
            val cache = SharedPreferencesCache.fromContext(activity.getApplicationContext())
            cachingIdProvider.cacheService = cache
            cachingIdentityService.cacheService = cache
            val audioManager = activity.getSystemService(Context.AUDIO_SERVICE) as AudioManager
            if (audioManager.isBluetoothScoAvailableOffCall) {
                if (!audioManager.isBluetoothScoOn) {
                    audioManager.startBluetoothSco()
                }
            } else {
                println("SCO ist not available")
            }
            audioRecorder.buildRecorder()

            return Client(
                    appId,
                    language,
                    cachingIdProvider,
                    cachingIdentityService,
                    GrpcSluClient.forTarget(target, secure),
                    audioRecorder
            )
        }
    }

    var segmentChangeCb: ((segment: Segment) -> Unit)? = null

    override fun onSegmentChange(block: (segment: Segment) -> Unit) {
        segmentChangeCb = block
    }

    var transcriptCb: ((transcript: Transcript) -> Unit)? = null

    override fun onTranscript(block: (transcript: Transcript) -> Unit) {
        transcriptCb = block
    }

    var tentativeTranscriptCb: ((transcripts: List<Transcript>) -> Unit)? = null

    override fun onTentativeTranscript(block: (transcripts: List<Transcript>) -> Unit) {
        tentativeTranscriptCb = block
    }

    var tentativeEntitiesCb: ((entities: List<Entity>) -> Unit)? = null

    override fun onTentativeEntities(block: (entities: List<Entity>) -> Unit) {
        tentativeEntitiesCb = block
    }

    var entityCb: ((entity: Entity) -> Unit)? = null

    override fun onEntity(block: (entity: Entity) -> Unit) {
        entityCb = block
    }

    var tentativeIntentCb: ((intent: Intent) -> Unit)? = null

    override fun onTentativeIntent(block: (intent: Intent) -> Unit) {
        tentativeIntentCb = block
    }

    var intentCb: ((intent: Intent) -> Unit)? = null

    override fun onIntent(block: (intent: Intent) -> Unit) {
        intentCb = block
    }

    @DelicateCoroutinesApi
    @ExperimentalCoroutinesApi
    override fun startContext() {
        coroutineScope.launch(Dispatchers.IO) {
            val token = identityService.authenticate(appId, deviceId)
            try {
                val audioFlow: Flow<ByteArray> = audioRecorder.startRecording()
                val stream = sluClient.stream(token, streamConfig, audioFlow)
                streams.add(stream)

                var segment: Segment? = null
                withContext(Dispatchers.Default) {
                    try {
                        stream.responseFlow?.collect { response: SLUResponse ->
                            if (segment == null) {
                                segment = Segment(response.audioContext, response.segmentId)
                            }
                            when (response.streamingResponseCase) {
                                SLUResponse.StreamingResponseCase.STARTED -> {
                                }
                                SLUResponse.StreamingResponseCase.FINISHED -> {
                                }
                                SLUResponse.StreamingResponseCase.TRANSCRIPT -> {
                                    val transcript = Transcript.fromSluReponse(response, true)
                                    segment?.updateTranscript(transcript.word)
                                    transcriptCb?.invoke(transcript)
                                }
                                SLUResponse.StreamingResponseCase.INTENT -> {
                                    val intent = Intent.fromSluReponse(response, true)
                                    segment?.updateIntent(intent)
                                    intentCb?.invoke(intent)
                                }
                                SLUResponse.StreamingResponseCase.ENTITY -> {
                                    val entity = Entity.fromSluReponse(response, true)
                                    segment?.updateEntity(entity)
                                    entityCb?.invoke(entity)
                                }
                                SLUResponse.StreamingResponseCase.TENTATIVE_INTENT -> {
                                    val intent = Intent.fromSluReponse(response, false)
                                    segment?.updateIntent(intent)
                                    tentativeIntentCb?.invoke(intent)
                                }
                                SLUResponse.StreamingResponseCase.TENTATIVE_ENTITIES -> {
                                    val entities = mutableListOf<Entity>()
                                    for(sluEntity in response.tentativeEntities.getTentativeEntitiesList()){
                                        val entity = Entity.fromSluEntity(
                                            response.audioContext,
                                            response.segmentId,
                                            sluEntity,
                                            false)
                                        entities.add(entity)
                                    }
                                    segment?.updateEntities(entities)
                                    tentativeEntitiesCb?.invoke(entities)
                                }
                                SLUResponse.StreamingResponseCase.TENTATIVE_TRANSCRIPT -> {
                                    val transcripts = mutableListOf<Transcript>()
                                    for(sluTranscript in response.tentativeTranscript.tentativeWordsList){
                                        val transcript = Transcript.fromSluTranscript(
                                            response.audioContext,
                                            response.segmentId,
                                            sluTranscript,
                                            false)
                                        transcripts.add(transcript)
                                    }
                                    segment?.updateTranscripts(transcripts)
                                    tentativeTranscriptCb?.invoke(transcripts)
                                }
                                SLUResponse.StreamingResponseCase.SEGMENT_END -> {
                                    segment?.finalize()
                                }
                                SLUResponse.StreamingResponseCase.RTT_REQUEST -> {
                                    // TODO: refactor to send RTTResponse
                                }
                                else -> println("Unhandled response case")
                            }
                            segment.let {
                                segmentChangeCb?.invoke(segment!!)
                            }
                        }
                    } catch (e: Exception) {
                        println("The flow has thrown an exception: $e")
                    }
                }
            } catch (t: Throwable) {
                println("The stream has thrown an exception: $t")
//                callback.onError(t)
            }
        }
    }

    override fun stopContext() {
        this.audioRecorder.stopRecording()
        this.getReadStream()?.let {
            it.close()
            this.streams.remove(it)
        }
        this.coroutineScope.cancel()
    }

    override fun close() {
        this.audioRecorder.close()
        this.sluClient.close()
        this.identityService.close()
    }

    private fun getReadStream(): SluStream? {
        if (this.streams.isEmpty()) {
            return null
        }

        // Always use the last stream for reading.
        return this.streams.last()
    }
}

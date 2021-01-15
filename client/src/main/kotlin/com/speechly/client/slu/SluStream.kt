package com.speechly.client.slu

import com.google.protobuf.ByteString
import com.speechly.api.slu.v1.SLUGrpcKt
import com.speechly.api.slu.v1.Slu
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.receiveAsFlow
import java.io.Closeable

private val startReq: Slu.SLURequest = Slu.SLURequest
        .newBuilder()
        .setEvent(
                Slu.SLUEvent
                        .newBuilder()
                        .setEvent(Slu.SLUEvent.Event.START)
                        .build()
        ).build()

private val stopReq: Slu.SLURequest = Slu.SLURequest
        .newBuilder()
        .setEvent(
                Slu.SLUEvent
                        .newBuilder()
                        .setEvent(Slu.SLUEvent.Event.STOP)
                        .build()
        ).build()

/**
 * An interface representing a single SLU stream between the client and Speechly SLU API.
 */
interface SluStream : Closeable {
    /**
     * Writes an audio chunk to a stream.
     *
     * @param audioChunk a chunk of binary audio data.
     */
    suspend fun write(audioChunk: ByteArray)

    /**
     * Returns a Flow containing individual responses (transcripts, entities and intents).
     */
    fun toFlow(): Flow<Response>

    /**
     * Returns a Flow containing segment states.
     */
    fun toSegmentFlow(): Flow<Segment>

    /**
     * Returns true when the stream has been acknowledged by the API, false otherwise.
     * After the stream is closed, this will continue to return true.
     */
    fun hasStarted(): Boolean

    /**
     * Returns true when the stream has been closed by the API, false otherwise.
     */
    fun isClosed(): Boolean
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
        private val requestChannel: Channel<ByteArray> = Channel(),
        private val responseChannel: Channel<Slu.SLUResponse> = Channel()
) : SluStream {
    private var isClosed: Boolean = false
    private var isStarted: Boolean = false

    init {
        val channel = this.requestChannel
        val requestFlow: Flow<Slu.SLURequest> = flow {
            // The builder is re-used for sending audio requests
            val builder = Slu.SLURequest.newBuilder()
            val configReq = builder.setConfig(
                    Slu.SLUConfig.newBuilder()
                            .setChannels(streamConfig.channelCount)
                            .setSampleRateHertz(streamConfig.sampleRateHertz)
                            .setLanguageCode(streamConfig.languageCode.stringValue)
                            .setEncoding(Slu.SLUConfig.Encoding.LINEAR16)
                            .build()
            ).build()

            // According to protocol spec, first message in the stream has to be a SLU config.
            emit(configReq)

            // The client is design to send a single utterance per gRPC stream for simplicity,
            // so each stream sends a START event in the beginning.
            emit(startReq)

            // Main loop that sends audio chunks to the stream.
            for (chunk in channel) {
                val byteStr = ByteString.copyFrom(chunk)
                val req = builder.setAudio(byteStr).build()

                emit(req)
            }

            // When no more audio chunks are to be send, terminate the stream with a STOP event.
            emit(stopReq)
        }

        clientStub.stream(requestFlow).map { response ->
            if (this.responseChannel.isClosedForSend) {
                throw StreamClosedException()
            }

            when (response.streamingResponseCase) {
                Slu.SLUResponse.StreamingResponseCase.STARTED -> {
                    this.isStarted = true
                }
                Slu.SLUResponse.StreamingResponseCase.FINISHED -> {
                    this.isClosed = true
                }
                else -> {
                    this.responseChannel.send(response)
                }
            }
        }
    }

    @ExperimentalCoroutinesApi
    override suspend fun write(audioChunk: ByteArray) {
        if (this.requestChannel.isClosedForSend) {
            throw StreamClosedException()
        }

        this.requestChannel.send(audioChunk)
    }

    private val segments: MutableMap<Int, Segment> = mutableMapOf()
    override fun toFlow(): Flow<Response> {
        return this.responseChannel.receiveAsFlow().map {
            // TODO: update and emit segment state here.
            // TODO: map responses here.
            Transcript(
                    contextId = "",
                    segmentId = 0,
                    isFinal = true,
                    index =  0,
                    value = "",
            )
        }
    }

    override fun toSegmentFlow(): Flow<Segment> {
        // TODO: stream segment states here.
        TODO("Not yet implemented")
    }

    override fun hasStarted(): Boolean {
        return this.isStarted
    }

    override fun isClosed(): Boolean {
        return this.isClosed
    }

    @ExperimentalCoroutinesApi
    override fun close() {
        // Close the request channel first, to indicate to the API that no more data is to be sent.
        this.requestChannel.close()

        // Wait for responses to be drained.
        while (!this.responseChannel.isEmpty) {
            Thread.sleep(10)
        }

        // Close the response channel as well and terminate the stream.
        this.responseChannel.close()
    }
}

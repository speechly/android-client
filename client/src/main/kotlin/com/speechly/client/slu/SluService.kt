package com.speechly.client.slu

import com.speechly.api.slu.v1.Slu
import com.speechly.client.identity.AuthToken
import java.io.Closeable
import java.lang.Exception

/**
 * This class represents an exception indicating that there is no active stream to interact with.
 */
class NoActiveStreamException : Exception("No active SLU stream available")

/**
 * This class represents a service that performs streaming recognition using Speechly SLU API.
 * By default it uses a client that uses Speechly SLU gRPC API.
 *
 * @param client an implementation of SLU client logic.
 */
class SluService(private val client: SluClient): Closeable {
    private val streams: MutableList<SluStream> = mutableListOf()

    companion object {
        /**
         * Creates a new SLU service using default gRPC client implementation.
         *
         * @param target the address of the API endpoint to connect to, e.g. "api.speechly.com"
         * @param secure whether to use secured (TLS) or plaintext connection
         */
        fun forTarget(
                target: String = "api.speechly.com",
                secure: Boolean = true
        ): SluService {
            return SluService(
                GrpcSluClient.forTarget(target, secure)
            )
        }
    }

    /**
     * Starts a new SLU stream and marks it as current for reading and writing.
     *
     * @param authToken token to use for authenticating to the API.
     * @param streamConfig the configuration of the SLU stream.
     */
    fun startStream(authToken: AuthToken, streamConfig: StreamConfig) {
        this.newStream(authToken, streamConfig)
    }

    /**
     * Stops currently active SLU stream and blocks until it has been drained.
     */
    fun stopStream() {
        // Always stop the currently active read stream.
        val stream = this.getReadStream()

        // Start closing it and wait until its drained.
        stream.close()

        // Once drained, we can remove it from the list.
        this.streams.remove(stream)
    }

    /**
     * Starts and returns a new SLU stream.
     *
     * @param authToken token to use for authenticating to the API.
     * @param streamConfig the configuration of the SLU stream.
     */
    fun newStream(authToken: AuthToken, streamConfig: StreamConfig): SluStream {
        val stream = this.client.stream(authToken, streamConfig)
        this.streams.add(stream)
        return stream
    }

    /**
     * Reads a response from current stream, when available.
     */
    suspend fun read(): Slu.SLUResponse {
        return this.getReadStream().read()
    }

    /**
     * Writes an audio chunk to current stream.
     *
     * @param audioChunk a chunk of binary audio data.
     */
    suspend fun write(audioChunk: ByteArray) {
        return this.getWriteStream().write(audioChunk)
    }

    override fun close() {
        this.streams.forEach {
            it.close()
        }

        this.client.close()
    }

    private fun getReadStream(): SluStream {
        if (this.streams.isEmpty()) {
            throw NoActiveStreamException()
        }

        // Always use the last stream for reading.
        return this.streams.last()
    }

    private fun getWriteStream(): SluStream {
        if (this.streams.isEmpty()) {
            throw NoActiveStreamException()
        }

        // Always use the first stream for writing.
        return this.streams.first()
    }
}

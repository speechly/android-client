package com.speechly.client.slu

import com.speechly.client.identity.AuthToken
import java.io.Closeable

/**
 * This class represents a service that performs streaming recognition using Speechly SLU API.
 * By default it uses a client that uses Speechly SLU gRPC API.
 */
interface SluService : Closeable {
    /**
     * Starts and returns a new SLU stream.
     *
     * @param authToken token to use for authenticating to the API.
     * @param streamConfig the configuration of the SLU stream.
     */
    fun stream(authToken: AuthToken, streamConfig: StreamConfig): SluStream
}

/**
 * This class represents a service that performs streaming recognition using Speechly SLU API.
 * By default it uses a client that uses Speechly SLU gRPC API.
 *
 * @param client an implementation of SLU client logic.
 */
class StreamingSluService(private val client: SluClient): SluService {
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
        ): StreamingSluService {
            return StreamingSluService(
                GrpcSluClient.forTarget(target, secure)
            )
        }
    }

    override fun stream(authToken: AuthToken, streamConfig: StreamConfig): SluStream {
        return this.client.stream(authToken, streamConfig)
    }

    override fun close() {
        this.client.close()
    }
}

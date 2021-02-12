package com.speechly.client.slu

import com.speechly.api.slu.v1.SLUGrpcKt
import com.speechly.client.grpc.buildChannel
import com.speechly.client.identity.AuthToken
import io.grpc.ManagedChannel
import io.grpc.Metadata
import io.grpc.stub.MetadataUtils
import kotlinx.coroutines.ExperimentalCoroutinesApi
import java.io.Closeable
import java.util.concurrent.TimeUnit
import kotlinx.coroutines.flow.Flow

/**
 * An interface representing a client for Speechly SLU API.
 */
interface SluClient : Closeable {
    /**
     * Creates a new SLU stream between the client and the API.
     *
     * @param authToken token to use for authenticating to the API.
     * @param streamConfig the configuration of the SLU stream.
     */
    fun stream(authToken: AuthToken, streamConfig: StreamConfig, audioFlow: Flow<ByteArray>): SluStream
}

/**
 * A client for Speechly gRPC SLU API.
 *
 * @param channel the gRPC channel to use for sending requests to the API
 * @param shutdownTimeout the timeout for closing the gRPC channel
 */
class GrpcSluClient(
    private val channel: ManagedChannel,
    private val shutdownTimeout: Long = 5
) : SluClient {
    private val clientStub = SLUGrpcKt.SLUCoroutineStub(this.channel)

    companion object {
        /**
         * Constructs a new client that connects to specified API endpoint.
         *
         * @param target the address of the API endpoint to connect to, e.g. "api.speechly.com"
         * @param secure whether to use secured (TLS) or plaintext connection
         */
        fun forTarget(target: String, secure: Boolean): GrpcSluClient {
            return GrpcSluClient(
                buildChannel(target, secure)
            )
        }
    }

    @ExperimentalCoroutinesApi
    override fun stream(authToken: AuthToken, streamConfig: StreamConfig, audioFlow: Flow<ByteArray>): GrpcSluStream {
        val metadata = Metadata()
        metadata.put(
            Metadata.Key.of("Authorization", Metadata.ASCII_STRING_MARSHALLER),
            "Bearer ${authToken.tokenString}"
        )

        return GrpcSluStream(
                MetadataUtils.attachHeaders(this.clientStub, metadata),
                streamConfig,
                audioFlow
        )
    }

    override fun close() {
        this.channel.shutdown().awaitTermination(this.shutdownTimeout, TimeUnit.SECONDS)
    }
}

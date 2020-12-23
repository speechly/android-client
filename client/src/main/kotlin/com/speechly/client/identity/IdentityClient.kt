package com.speechly.client.identity

import com.speechly.api.identity.v1.IdentityGrpcKt
import com.speechly.api.identity.v1.IdentityOuterClass
import com.speechly.client.grpc.buildChannel
import io.grpc.ManagedChannel
import io.grpc.Status
import java.io.Closeable
import java.lang.Exception
import java.util.concurrent.TimeUnit

/**
 * An interface representing a client for Speechly Identity API.
 */
interface IdentityClient : Closeable {
    /**
     * Performs a login against the API using provided request.
     *
     * @param request the login request that is sent to the API.
     */
    suspend fun login(request: IdentityOuterClass.LoginRequest): IdentityOuterClass.LoginResponse
}

/**
 * An exception that represents an invalid appId rejected by the API.
 */
class InvalidApplicationException(message: String): Exception(message)

/**
 * An exception that represents a general authentication error returned by the API.
 */
class AuthenticationException(message: String): Exception(message)


/**
 * A client for Speechly gRPC Identity API.
 *
 * @param channel the gRPC channel to use for sending requests to the API
 * @param shutdownTimeout the timeout for closing the gRPC channel
 */
class GrpcIdentityClient(
        private val channel: ManagedChannel,
        private val shutdownTimeout: Long = 5
) : IdentityClient {
    private val clientStub = IdentityGrpcKt.IdentityCoroutineStub(this.channel)

    companion object {
        /**
         * Constructs a new client that connects to specified API endpoint.
         *
         * @param target the address of the API endpoint to connect to, e.g. "api.speechly.com"
         * @param secure whether to use secured (TLS) or plaintext connection
         */
        fun forTarget(target: String, secure: Boolean): GrpcIdentityClient {
            return GrpcIdentityClient(
                buildChannel(target, secure)
            )
        }
    }

    override suspend fun login(request: IdentityOuterClass.LoginRequest): IdentityOuterClass.LoginResponse {
        val response: IdentityOuterClass.LoginResponse

        try {
            response = this.clientStub.login(request)
        } catch (e: Exception) {
            when (val s = Status.fromThrowable(e)) {
                Status.PERMISSION_DENIED -> throw AuthenticationException(s.description ?: "Authentication failed")
                Status.NOT_FOUND -> throw InvalidApplicationException(s.description ?: "Invalid appId")
                else -> throw e
            }
        }

        return response
    }

    override fun close() {
        this.channel.shutdown().awaitTermination(this.shutdownTimeout, TimeUnit.SECONDS)
    }
}

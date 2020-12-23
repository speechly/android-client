package com.speechly.client.identity

import com.speechly.api.identity.v1.IdentityOuterClass
import java.io.Closeable
import java.util.UUID

/**
 * This class represents a service that returns authentication tokens obtained from Speechly Identity API.
 * By default it uses a client that uses Speechly Identity gRPC API.
 *
 * @param client an implementation of identity client logic.
 */
class IdentityService(private val client: IdentityClient) : Closeable by client {
    companion object {
        /**
         * Creates a new identity service using default gRPC client implementation.
         *
         * @param target the address of the API endpoint to connect to, e.g. "api.speechly.com"
         * @param secure whether to use secured (TLS) or plaintext connection
         */
        fun forTarget(
            target: String = "api.speechly.com",
            secure: Boolean = true
        ): IdentityService {
            return IdentityService(
                GrpcIdentityClient.forTarget(target, secure)
            )
        }
    }

    /**
     * Fetches a new authentication token and decodes it into `AuthToken`.
     *
     * @param appId Speechly application ID to use for authentication.
     * @param deviceId Speechly device ID to use for authentication.
     */
    suspend fun authenticate(appId: UUID, deviceId: UUID): AuthToken {
        val request = IdentityOuterClass.LoginRequest
            .newBuilder()
            .setAppId(appId.toString())
            .setDeviceId(deviceId.toString())
            .build()

        val response = client.login(request)

        return AuthToken.fromJWT(response.token)
    }
}

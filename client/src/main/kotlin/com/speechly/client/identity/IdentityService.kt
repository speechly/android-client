package com.speechly.client.identity

import com.speechly.api.identity.v1.IdentityOuterClass
import com.speechly.client.cache.PersistentCache
import java.io.Closeable
import java.time.Instant
import java.util.UUID

/**
 * An interface for a service that returns authentication tokens obtained from Speechly Identity API.
 */
interface IdentityService : Closeable {
    /**
     * Fetches a new authentication token and decodes it into `AuthToken`.
     *
     * @param appId Speechly application ID to use for authentication.
     * @param deviceId Speechly device ID to use for authentication.
     */
    suspend fun authenticate(appId: UUID, deviceId: UUID): AuthToken
}

/**
 * Implements the IdentityService interface by calling the underlying API client and parsing its result into AuthToken.
 * By default it uses a client that uses Speechly Identity gRPC API.
 *
 * @param client an implementation of identity client logic.
 */
class BasicIdentityService(
        private val client: IdentityClient
) : IdentityService {
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
        ): BasicIdentityService {
            return BasicIdentityService(
                GrpcIdentityClient.forTarget(target, secure)
            )
        }
    }

    override suspend fun authenticate(appId: UUID, deviceId: UUID): AuthToken {
        val request = IdentityOuterClass.LoginRequest
            .newBuilder()
            .setAppId(appId.toString())
            .setDeviceId(deviceId.toString())
            .build()

        val response = client.login(request)

        return AuthToken.fromJWT(response.token)
    }

    override fun close() {
        this.client.close()
    }
}

/**
 * Implements the IdentityService interface by fetching the tokens from the base service implementation
 * and using a persistent cache to store them for future use.
 *
 * @param baseService an IdentityService implementation used for fetching tokens in case of cache miss
 * @param cache an implementation of PersistentCache that is used for storing cached tokens
 */
class CachingIdentityService(
        private val baseService: IdentityService,
        private val cache: PersistentCache
) : IdentityService {
    companion object {
        /**
         * Creates a new identity service using default gRPC client implementation.
         *
         * @param cache an implementation of PersistentCache that is used for storing cached tokens
         * @param target the address of the API endpoint to connect to, e.g. "api.speechly.com"
         * @param secure whether to use secured (TLS) or plaintext connection
         */
        fun forTarget(
                cache: PersistentCache,
                target: String = "api.speechly.com",
                secure: Boolean = true
        ): CachingIdentityService {
            return CachingIdentityService(
                    BasicIdentityService.forTarget(target, secure),
                    cache,
            )
        }
    }

    override suspend fun authenticate(appId: UUID, deviceId: UUID): AuthToken {
        // Try to load the token from the cache.
        val token = this.loadToken(appId, deviceId)

        // Make sure that cached token exists and won't expire too soon.
        val expirationTime = Instant.now().plusSeconds(60)
        if (token != null && token.validateExpiry(expirationTime)) {
            return token
        }

        // Otherwise reload the token from the API and update the cached value.
        return this.reloadToken(appId, deviceId)
    }

    override fun close() {
        this.baseService.close()
    }

    private fun loadToken(appId: UUID, deviceId: UUID): AuthToken? {
        val cacheValue = this.cache.loadString(this.makeCacheKey(appId, deviceId)) ?: return null

        return try {
            AuthToken.fromJWT(cacheValue)
        } catch (_: Throwable) {
            null
        }
    }

    private suspend fun reloadToken(appId: UUID, deviceId: UUID): AuthToken {
        val token = this.baseService.authenticate(appId, deviceId)

        this.cache.storeString(this.makeCacheKey(token.appId, token.deviceId), token.tokenString)

        return token
    }

    private val cacheKeyPrefix = "speechly.authToken"
    private fun makeCacheKey(appId: UUID, deviceId: UUID): String {
        return "${this.cacheKeyPrefix}.${appId}.${deviceId}"
    }
}
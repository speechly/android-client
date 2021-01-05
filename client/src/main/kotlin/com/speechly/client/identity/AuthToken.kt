package com.speechly.client.identity

import com.beust.klaxon.Json
import com.beust.klaxon.Klaxon
import java.lang.Exception
import java.time.Instant
import java.util.UUID
import java.util.Base64

/**
 * This class represents a malformed JWT exception.
 * It is thrown by the code that parses JWTs received from Speechly Identity service.
 *
 * @param message detailed message describing the specifics of the exception.
 */
class InvalidJWTException(message: String) : Exception(message)

/**
 * This data class represents an authentication token that can be used to access public Speechly API.
 * The token is usually obtained from Speechly Identity Service and can be cached for its expiration period.
 *
 * @param appId the ID of Speechly application that will be accessed with this token.
 * @param deviceId Speechly device identifier that is authorised to use this token.
 * @param expiresAt the timestamp of token expiration.
 * @param authScopes Speechly APIs that can be accessed with this token.
 * @param tokenString the token value that should be passed to API when accessing it.
 */
data class AuthToken(
        val appId: UUID,
        val deviceId: UUID,
        val expiresAt: Instant,
        val authScopes: Set<AuthScope>,
        val tokenString: String
) {
    /**
     * This enum class represents known Speechly APIs scopes which are returned in the token payload.
     */
    enum class AuthScope {
        SLU, WLU
    }

    companion object {
        /**
         * Parses the authentication token from its string representation.
         *
         * @param jwt the string representation of the token,
         * normally returned by Speechly Identity service.
         */
        fun fromJWT(jwt: String): AuthToken {
            val bodyStr = jwt.split('.')
            if (bodyStr.size != 3) {
                throw InvalidJWTException("Malformed token")
            }

            val body = try {
                String(Base64.getDecoder().decode(bodyStr[1]))
            } catch (e: Throwable) {
                throw InvalidJWTException(e.message ?: "Malformed token")
            }

            val payload = Klaxon().parse<TokenPayload>(body) ?: throw InvalidJWTException("Invalid token payload")

            val scopes = mutableSetOf<AuthScope>()
            for (s in payload.scopes.split(' ')) {
                when (s) {
                    "slu" -> scopes.add(AuthScope.SLU)
                    "wlu" -> scopes.add(AuthScope.WLU)
                }
            }

            return try {
                AuthToken(
                        appId = UUID.fromString(payload.appId),
                        deviceId = UUID.fromString(payload.deviceId),
                        expiresAt = Instant.ofEpochSecond(payload.expiresAt),
                        authScopes = scopes,
                        tokenString = jwt
                )
            } catch (e: Throwable) {
                throw InvalidJWTException(e.message ?: "Invalid token payload")
            }
        }
    }

    /**
     * Validates the token against provided identifiers and expiration date.
     * Returns true if the token is valid, false otherwise.
     *
     * @param appId Speechly application ID to verify against.
     * @param deviceId Speechly device ID to verify against.
     * @param expiresAt timestamp to check expiration against.
     */
    fun validate(appId: UUID, deviceId: UUID, expiresAt: Instant): Boolean {
        return this.appId == appId && this.deviceId == deviceId && this.validateExpiry(expiresAt)
    }

    /**
     * Validates the expiry of the token against provided timestamp.
     *
     * @param expiresAt timestamp to check expiration against.
     */
    fun validateExpiry(expiresAt: Instant): Boolean {
        return this.expiresAt.isBefore(expiresAt)
    }
}

private data class TokenPayload(
    val appId: String,
    val deviceId: String,

    @Json(name = "scope")
    val scopes: String,

    @Json(name = "exp")
    val expiresAt: Long
)
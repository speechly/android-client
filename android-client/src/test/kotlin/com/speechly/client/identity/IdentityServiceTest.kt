package com.speechly.client.identity

import com.speechly.identity.v2.LoginRequest
import com.speechly.identity.v2.LoginResponse
import kotlinx.coroutines.runBlocking
import java.util.stream.Stream
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import strikt.api.*
import strikt.assertions.*
import java.time.Instant
import java.util.*

internal class IdentityServiceTest {
    @ParameterizedTest(name = "should handle authentication for `token = {0}` `exception = {1}`")
    @MethodSource("authenticateArgs")
    fun shouldAuthenticate(
        token: String,
        exception: Throwable?,
        want: AuthToken,
        wantException: Boolean
    ) = runBlocking<Unit> {
        val id = UUID.randomUUID()
        val response = LoginResponse.newBuilder().setToken(token).build()
        val client = MockIdentityClient(response, exception)
        val service = BasicIdentityService(client)

        if (wantException) {
            expectCatching {
                service.authenticate(id, id)
            }.isFailure()
        } else {
            val actual = service.authenticate(id, id)
            expectThat(actual).isEqualTo(want)
        }
    }

    private companion object {
        @JvmStatic
        fun authenticateArgs() = Stream.of(
            Arguments.of(
                "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhcHBJZCI6IjExMTExMTExLTExMTEtMTExMS0xMTExLTExMTExMTExMTExMSIsImRldmljZUlkIjoiMjIyMjIyMjItMjIyMi0yMjIyLTIyMjItMjIyMjIyMjIyMjIyIiwiY29uZmlnSWQiOiIzMzMzMzMzMy0zMzMzLTMzMzMtMzMzMy0zMzMzMzMzMzMzMzMiLCJsYW5ndWFnZUNvZGUiOiJlbi1VUyIsInNjb3BlIjoic2x1IHdsdSIsImlzcyI6Imh0dHBzOi8vYXBpLnNwZWVjaGx5LmNvbSIsImF1ZCI6Imh0dHBzOi8vYXBpLnNwZWVjaGx5LmNvbSIsImlhdCI6MTU5OTIzOTAyMiwiZXhwIjoxOTA5MjM5MDIyfQ.zBvA4ahMj5LAzDac61rvw0KwW35X7XkTIiY8AvYf_4I",
                null,
                AuthToken(
                    appId = UUID.fromString("11111111-1111-1111-1111-111111111111"),
                    deviceId = UUID.fromString("22222222-2222-2222-2222-222222222222"),
                    expiresAt = Instant.ofEpochSecond(1909239022),
                    authScopes = setOf(AuthToken.AuthScope.WLU, AuthToken.AuthScope.SLU),
                    tokenString ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhcHBJZCI6IjExMTExMTExLTExMTEtMTExMS0xMTExLTExMTExMTExMTExMSIsImRldmljZUlkIjoiMjIyMjIyMjItMjIyMi0yMjIyLTIyMjItMjIyMjIyMjIyMjIyIiwiY29uZmlnSWQiOiIzMzMzMzMzMy0zMzMzLTMzMzMtMzMzMy0zMzMzMzMzMzMzMzMiLCJsYW5ndWFnZUNvZGUiOiJlbi1VUyIsInNjb3BlIjoic2x1IHdsdSIsImlzcyI6Imh0dHBzOi8vYXBpLnNwZWVjaGx5LmNvbSIsImF1ZCI6Imh0dHBzOi8vYXBpLnNwZWVjaGx5LmNvbSIsImlhdCI6MTU5OTIzOTAyMiwiZXhwIjoxOTA5MjM5MDIyfQ.zBvA4ahMj5LAzDac61rvw0KwW35X7XkTIiY8AvYf_4I",
                    projectId = null
                ),
                false
            ),
            Arguments.of(
                "",
                null,
                AuthToken(
                    appId = UUID.randomUUID(),
                    deviceId = UUID.randomUUID(),
                    expiresAt = Instant.MAX,
                    authScopes = emptySet(),
                    tokenString ="",
                    projectId = null
                ),
                true
            ),
            Arguments.of(
                "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhcHBJZCI6IjExMTExMTExLTExMTEtMTExMS0xMTExLTExMTExMTExMTExMSIsImRldmljZUlkIjoiMjIyMjIyMjItMjIyMi0yMjIyLTIyMjItMjIyMjIyMjIyMjIyIiwiY29uZmlnSWQiOiIzMzMzMzMzMy0zMzMzLTMzMzMtMzMzMy0zMzMzMzMzMzMzMzMiLCJsYW5ndWFnZUNvZGUiOiJlbi1VUyIsInNjb3BlIjoic2x1IHdsdSIsImlzcyI6Imh0dHBzOi8vYXBpLnNwZWVjaGx5LmNvbSIsImF1ZCI6Imh0dHBzOi8vYXBpLnNwZWVjaGx5LmNvbSIsImlhdCI6MTU5OTIzOTAyMiwiZXhwIjoxOTA5MjM5MDIyfQ.zBvA4ahMj5LAzDac61rvw0KwW35X7XkTIiY8AvYf_4I",
                Throwable("some exception"),
                AuthToken(
                    appId = UUID.randomUUID(),
                    deviceId = UUID.randomUUID(),
                    expiresAt = Instant.MAX,
                    authScopes = emptySet(),
                    tokenString = "",
                    projectId = null
                ),
                true
            )
        )
    }
}

private class MockIdentityClient(
    private val response: LoginResponse,
    private val exception: Throwable?
) : IdentityClient {
    override suspend fun login(request: LoginRequest): LoginResponse {
        if (this.exception != null) {
            throw this.exception
        }

        return this.response
    }

    override fun close() {
        return
    }
}

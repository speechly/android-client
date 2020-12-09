package com.speechly.client.grpc

import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder

/**
 * Performs a login against the API using provided request.
 *
 * @param target - the address of the API endpoint, e.g. "api.speechly.com"
 * @param secure - whether to use secured (TLS) or plaintext connection
 */
internal fun buildChannel(target: String, secure: Boolean): ManagedChannel {
    val builder = if (secure) {
        ManagedChannelBuilder
            .forTarget(target)
            .useTransportSecurity()
    } else {
        ManagedChannelBuilder
            .forTarget(target)
            .usePlaintext()
    }

    return builder.build()
}

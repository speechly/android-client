package com.speechly.client.slu

sealed class Response {
    abstract val contextId: String
    abstract val segmentId: Int
    abstract val isFinal: Boolean
}

data class Transcript(
        override val contextId: String,
        override val segmentId: Int,
        override val isFinal: Boolean,
        val index: Int,
        val value: String
) : Response()

data class Entity(
        override val contextId: String,
        override val segmentId: Int,
        override val isFinal: Boolean,
        val startIndex: Int,
        val endIndex: Int,
        val type: String,
        val value: String,
) : Response()

data class Intent(
        override val contextId: String,
        override val segmentId: Int,
        override val isFinal: Boolean,
        val value: String
) : Response()

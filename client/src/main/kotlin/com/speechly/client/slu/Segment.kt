package com.speechly.client.slu

data class Segment(
        val contextId: String,
        val segmentId: Int,
        val isFinal: Boolean,
)

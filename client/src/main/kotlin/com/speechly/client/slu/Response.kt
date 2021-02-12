package com.speechly.client.slu

import com.speechly.api.slu.v1.Slu
import com.speechly.api.slu.v1.Slu.SLUResponse

sealed class Response {
    abstract val contextId: String
    abstract val segmentId: Int
}

data class Transcript(
        override val contextId: String,
        override val segmentId: Int,
        val word: Word
) : Response() {
    companion object {
        fun fromSluReponse(response: SLUResponse, isFinal: Boolean = true): Transcript {
            return Transcript(
                    contextId = response.audioContext,
                    segmentId = response.segmentId,
                    word = Word(
                            value = response.transcript.word,
                            index = response.transcript.index,
                            startTimestamp = response.transcript.startTime,
                            endTimestamp = response.transcript.endTime,
                            isFinal = isFinal
                    )
            )
        }

        fun fromSluTranscript(audioContext: String, segmentId: Int, transcript: Slu.SLUTranscript, isFinal: Boolean = true): Transcript {
            return Transcript(
                    contextId = audioContext,
                    segmentId = segmentId,
                    word = Word(
                            value = transcript.word,
                            index = transcript.index,
                            startTimestamp = transcript.startTime,
                            endTimestamp = transcript.endTime,
                            isFinal = isFinal
                    )
            )
        }
    }
}

/**
 * A single entity detected by the SLU API.
 */
data class Entity(
        override val contextId: String,
        override val segmentId: Int,
        val isFinal: Boolean,
        val startPosition: Int,
        val endPosition: Int,
        val type: String,
        val value: String
) : Response() {
    companion object {
        fun fromSluReponse(response: SLUResponse, isFinal: Boolean = true): Entity {
            return Entity(
                    contextId = response.audioContext,
                    segmentId = response.segmentId,
                    isFinal = isFinal,
                    startPosition = response.entity.startPosition,
                    endPosition = response.entity.endPosition,
                    type = response.entity.entity,
                    value = response.entity.value
            )
        }

        fun fromSluEntity(audioContext: String, segmentId: Int, entity: Slu.SLUEntity, isFinal: Boolean = true): Entity {
            return Entity(
                    contextId = audioContext,
                    segmentId = segmentId,
                    isFinal = isFinal,
                    startPosition = entity.startPosition,
                    endPosition = entity.endPosition,
                    type = entity.entity,
                    value = entity.value
            )
        }
    }
}

/**
 * The intent detected by the SLU API.
 */
data class Intent(
        override val contextId: String,
        override val segmentId: Int,
        var isFinal: Boolean,
        var intent: String
) : Response() {
    companion object {
        fun fromSluReponse(response: SLUResponse, isFinal: Boolean = true): Intent {
            return Intent(
                    contextId = response.audioContext,
                    segmentId = response.segmentId,
                    isFinal = isFinal,
                    intent = response.intent.intent
            )
        }
    }
}

/**
 * A single word detected by the SLU API.
 */
data class Word(
        /**
         * The value of the word.
         */
        val value: String,

        /**
         * The index of the word within a segment.
         */
        val index: Int,

        /**
         * Start timestamp of the word within the audio of the context.
         */
        val startTimestamp: Int,

        /**
         * End timestamp of the word within the audio of the context.
         */
        val endTimestamp: Int,

        /**
         * Whether the word was detected as final.
         */
        val isFinal: Boolean
)


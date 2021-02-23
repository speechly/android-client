package com.speechly.client.slu

/**
 * The smallest component of SLU API, defined by an intent.
 */
class Segment(
        val contextId: String,
        val segmentId: Int
) {
    var isFinal: Boolean = false
    var intent: Intent? = null
    var entities: MutableMap<String, Entity> = mutableMapOf()
    var words:  MutableMap<Int, Word> = mutableMapOf()

    fun updateTranscript(word: Word): Unit {
        if (!this.isFinal || word.isFinal) {
            this.words.set(word.index, word)
        }
    }

    fun updateTranscripts(transcripts: MutableList<Transcript>): Unit {
        transcripts.forEach({ transcript ->
            // Only accept tentative words if the segment is tentative.
            if (!this.isFinal || transcript.word.isFinal) {
                this.words.set(transcript.word.index, transcript.word)
            }
        })
    }

    fun updateEntity(entity: Entity): Unit {
        if (!this.isFinal || entity.isFinal) {
            this.entities.set("${entity.startPosition}:${entity.endPosition}", entity)
        }
    }

    fun updateEntities(entities: MutableList<Entity>): Unit {
        entities.forEach( { entity ->
            // Only accept tentative entities if the segment is tentative.
            if (!this.isFinal || entity.isFinal) {
                this.entities.set("${entity.startPosition}:${entity.endPosition}", entity)
            }
        })
    }

    fun updateIntent(intent: Intent): Unit {
        if (!this.isFinal || intent.isFinal) {
            this.intent = intent
        }
    }

    fun finalize() {
        words = words.filter { (_, word) -> word.isFinal }.toMutableMap()
        entities.forEach {(key, entity) -> if (!entity.isFinal) entities.remove(key)}
        if (this.intent?.isFinal == false) {
            this.intent?.intent = ""
            this.intent?.isFinal = true
        }
        isFinal = true
    }

    fun getEntityByType(type: String): Entity? {
        return this.entities.values.filter{it.type == type}.firstOrNull()
    }
}
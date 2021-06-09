package scoring.vitrivr

import json.Categories
import json.SegmentDescriptor
import json.StringDoublePair

class MediaObjectScoreContainer {
    private val _segmentScores =
        HashMap<String, MediaSegmentScoreContainer>()
    private val _cache =
        HashMap<String, MutableList<CacheContainer>>()
    val segments: MutableList<MediaSegmentScoreContainer> =
        mutableListOf()
    private var _score = 0.0

    fun getSegmentDescriptor(segmentId: String): SegmentDescriptor? {
        return _segmentScores[segmentId]?.segmentDescriptor
    }

    fun update(func: VitrivrScoringAlgorithm) {
        this._score = func.scoreForObject(this)
    }

    fun addMediaSegment(segment: SegmentDescriptor): MediaSegmentScoreContainer? {
        val ssc = this.uniqueSegmentScoreContainer(segment)
        if (ssc != null) {
            if (this._cache.containsKey(ssc.segmentDescriptor.segmentId)) {
                this._cache[ssc.segmentDescriptor.segmentId]!!.forEach {
                    this.addSimilarity(
                        it.category,
                        it.similarity,
                        it.containerId
                    )
                }
                this._cache.remove(ssc.segmentDescriptor.segmentId)
            }
        }
        return ssc
    }

    fun addSimilarity(
        category: Categories,
        similarity: StringDoublePair,
        containerId: Int
    ) {
        when {
            this._segmentScores.containsKey(similarity.key) -> {
                this._segmentScores[similarity.key]!!.addSimilarity(
                    category,
                    similarity,
                    containerId
                )
            }
            this._cache.containsKey(similarity.key) -> {
                this._cache[similarity.key]!!.add(
                    CacheContainer(
                        category,
                        similarity,
                        containerId
                    )
                )
            }
            else -> {
                this._cache[similarity.key] = mutableListOf()
                this._cache[similarity.key]!!.add(
                    CacheContainer(
                        category,
                        similarity,
                        containerId
                    )
                )
            }
        }
    }

    private fun uniqueSegmentScoreContainer(segment: SegmentDescriptor): MediaSegmentScoreContainer? {
        if (!this._segmentScores.containsKey(segment.segmentId)) {
            val ssc = MediaSegmentScoreContainer(segment)
            this._segmentScores[segment.segmentId] = ssc
            this.segments.add(ssc)
        }
        return this._segmentScores[segment.segmentId]
    }

    override fun toString(): String {
        var s = "{ currentScore: $_score"
        segments.forEach { s += " $it, " }
        s += "}"
        return s
    }
}

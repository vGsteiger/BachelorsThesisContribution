package scoring.inverseDecay

import json.SegmentWeight

class ScoredSegment(val segmentId: String, private var score: Float) {

    fun addScore(s: SegmentWeight) {
        if (s.key == this.segmentId) {
            score += s.value
        }
    }

    fun getScore(): Float {
        return score
    }
}

data class EndAndScore(val endAbs: Float, val score: Float)
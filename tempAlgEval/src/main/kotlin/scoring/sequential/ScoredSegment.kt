package scoring.sequential

import json.SegmentDescriptor
import json.SegmentWeight

class ScoredSegment(val segmentId: String, private var score: Float, val descriptor: SegmentDescriptor) {

    fun addScore(s: SegmentWeight) {
        if (s.key == this.segmentId) {
            score += s.value
        }
    }

    fun getScore(): Float {
        return score
    }
}
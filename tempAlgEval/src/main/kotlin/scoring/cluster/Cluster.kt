package scoring.cluster

import json.Result
import kotlin.math.max
import kotlin.math.min

class Cluster(
    val objectId: String,
    private var startAbs: Float,
    private var endAbs: Float,
    private var score: Float
) {
    private var nSegments = 1

    fun addSegment(segment: ScoredSegment) {
        if (objectId == segment.objectId) {
            if (startAbs == segment.startabs && endAbs == segment.endabs) {
                score += segment.score
            } else {
                startAbs = min(startAbs, segment.startabs)
                endAbs = max(endAbs, segment.endabs)
                score += segment.score
                nSegments += 1
            }
        }
    }

    fun getScore(): Float {
        return score
    }

    fun getStartAbs(): Float {
        return startAbs
    }

    fun getEndAbs(): Float {
        return endAbs
    }

    override fun toString(): String {
        return "Cluster(objectId='$objectId', startAbs=$startAbs, endAbs=$endAbs, score=$score, nSegments=$nSegments)"
    }
}

data class ResultAndScore(
    val result: Result,
    val score: Float
)

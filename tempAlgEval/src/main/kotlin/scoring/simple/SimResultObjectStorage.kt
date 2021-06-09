package scoring.simple

import java.util.*

class SimResultObjectStorage {

    private val segmentScores = HashMap<String, Float>()

    fun addSegmentScores(segmentId: String, score: Float) {
        if (segmentScores.containsKey(segmentId)) {
            segmentScores[segmentId] = segmentScores[segmentId]!!.plus(score)
        } else {
            segmentScores[segmentId] = score
        }
    }

    fun temporallyOrderSegmentsNormalised(): SortedMap<String, Float> {
        val tmp = HashMap(segmentScores)
        return tmp.toSortedMap()
    }

    override fun toString(): String {
        var s = ""
        for (sc in segmentScores) {
            s += sc.key.toString() + " " + sc.value.toString() + "\n"
        }
        return s
    }
}

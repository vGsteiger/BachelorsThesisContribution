package scoring.simple

import json.SimilarityQueryResult
import utils.ObjectNotPresentException
import java.util.*

class SimResultContainerStorage {
    private val objects = HashMap<String, SimResultObjectStorage>()

    fun unpackSimilarityResult(similarityQueryResult: SimilarityQueryResult) {
        for (c in similarityQueryResult.content) {
            val objectId = c.key.substring(0, 7)
            if (objects.containsKey(objectId)) {
                objects[objectId]?.addSegmentScores(c.key, c.value)
            } else {
                val str = SimResultObjectStorage()
                str.addSegmentScores(c.key, c.value)
                objects[objectId] = str
            }
        }
    }

    fun getOrderedScoresForObjectId(objectId: String): SortedMap<String, Float> {
        if (objects.containsKey(objectId)) {
            return objects[objectId]!!.temporallyOrderSegmentsNormalised()
        } else {
            throw ObjectNotPresentException("")
        }
    }

    override fun toString(): String {
        var s = ""
        for (o in objects) {
            s += "Object id: " + o.key.toString() + ", values: " + o.value.toString() + "\n"
        }
        return s
    }
}

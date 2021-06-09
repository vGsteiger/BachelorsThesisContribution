package scoring.vitrivr

import json.Categories
import json.SegmentDescriptor
import json.StringDoublePair
import java.util.*

class MediaSegmentScoreContainer(val segmentDescriptor: SegmentDescriptor) {
    val scores = HashMap<Int, EnumMap<Categories, Double>>()

    fun addSimilarity(
        category: Categories,
        similarity: StringDoublePair,
        containerId: Int
    ) {
        if (similarity.key != this.segmentDescriptor.segmentId) {
            return
        }
        if (!this.scores.containsKey(containerId)) {
            this.scores[containerId] = EnumMap(Categories::class.java)
        }
        this.scores[containerId]?.set(category, similarity.value)
    }

    override fun toString(): String {
        var s = "{ segmetId ${segmentDescriptor.segmentId}"
        scores.forEach { (t, u) -> s += " containerId $t, similarities $u" }
        s += "}"
        return s
    }
}

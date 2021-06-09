package scoring.vitrivr

import json.Categories
import json.StringDoublePair

class Path(val pathMap: HashMap<Int, MediaSegmentScoreContainer>) {
    fun key(): String {
        return this.toString()
    }

    override fun toString(): String {
        return pathMap.toString()
    }
}

data class ScoredPath(
    val path: Path,
    val score: Double
)

data class CacheContainer(
    val category: Categories,
    val similarity: StringDoublePair,
    val containerId: Int
)

data class SegmentContainerIdentifier(
    val segmentId: String,
    val containerId: Int
) {
    fun key(): String {
        return this.toString()
    }
}

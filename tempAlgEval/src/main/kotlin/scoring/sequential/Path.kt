package scoring.sequential

class Path(val objectId: String, private val initSegment: ScoredSegment, private val initContainerId: Int) {
    private var score = 0f
    private var segments = ArrayList<ScoredSegment>()
    private var currentContainerId: Int = -1

    init {
        addSegment(initSegment, initContainerId)
    }

    fun addSegment(segment: ScoredSegment, containerId: Int) {
        if (segment.descriptor.objectId == objectId) {
            segments.add(segment)
            score += segment.getScore()
            currentContainerId = containerId
        }
    }

    fun setSegments(segments: ArrayList<ScoredSegment>) {
        this.segments = segments
    }

    fun setScore(score: Float) {
        this.score = score
    }

    fun setCurrentContainerId(ccId: Int) {
        this.currentContainerId = ccId
    }

    fun getCurrentContainerId(): Int {
        return currentContainerId
    }

    fun getHighestCurrentItem(): ScoredSegment {
        return segments.last()
    }

    fun getStartEndScore(): StartEndScore {
        val startAbs = segments[0].descriptor.startabs
        val endAbs = segments.last().descriptor.endabs
        return StartEndScore(startAbs, endAbs, score)
    }

    fun getScore(): Float {
        return score
    }

    fun getCopy(): PathCopy {
        return PathCopy(
            this.initSegment,
            this.initContainerId,
            this.objectId,
            this.score,
            ArrayList(this.segments.toList()),
            this.currentContainerId
        )
    }

    override fun toString(): String {
        return "Path(objectId='$objectId', initSegment=$initSegment, initContainerId=$initContainerId, score=$score, segments=$segments, currentContainerId=$currentContainerId)"
    }
}

data class PathCopy(
    val initSegment: ScoredSegment,
    val initContainerId: Int,
    val objectId: String,
    val score: Float,
    val segments: ArrayList<ScoredSegment>,
    val currentContainerId: Int
)

data class StartEndScore(val startAbs: Float, val endAbs: Float, val score: Float)

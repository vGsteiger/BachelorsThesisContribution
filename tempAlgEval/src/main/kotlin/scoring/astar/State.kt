package scoring.astar


class State(
    private var segments: ArrayList<ScoredObject.Segment>,
    timeDistance: Float,
    val containerId: Int,
    nContainers: Int
) {
    private var h: Float
    val nContainersLeft: Int
    private var nrOfSegments: Int = segments.size

    init {
        h = if (nrOfSegments == 1) {
            1f
        } else {
            val currentSegment = segments.last()
            val previousSegment = segments[segments.size - 2]
            if (previousSegment.segmentDescriptor.endabs <= currentSegment.segmentDescriptor.startabs
                && previousSegment.segmentDescriptor.endabs + timeDistance >= currentSegment.segmentDescriptor.endabs
            ) {
                (1.1f - ((currentSegment.segmentDescriptor.endabs - previousSegment.segmentDescriptor.endabs) / timeDistance)) * (nContainers - containerId).toFloat()
            } else {
                150f
            }
        }
        nContainersLeft = nContainers - containerId
    }

    fun getLastSegment(): ScoredObject.Segment {
        return segments.last()
    }

    fun getHeuristic(): Float {
        return h
    }

    fun getPath(): ArrayList<ScoredObject.Segment> {
        return segments
    }

    override fun hashCode(): Int {
        return segments.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as State

        if (segments != other.segments) return false

        return true
    }

    override fun toString(): String {
        return "State(segments=$segments, containerId=$containerId, h=$h, nContainersLeft=$nContainersLeft, nrOfSegments=$nrOfSegments)"
    }


}

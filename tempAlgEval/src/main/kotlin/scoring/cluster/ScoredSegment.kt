package scoring.cluster

import json.SegmentDescriptor

data class ScoredSegment(
    val segmentId: String,
    val objectId: String,
    val start: Int,
    val end: Int,
    val startabs: Float,
    val endabs: Float,
    val sequenceNumber: Int,
    val count: Int,
    val score: Float
)

class ScoredSegmentFactory {
    fun createScoredSegment(segmentDescriptor: SegmentDescriptor, score: Float): ScoredSegment {
        return ScoredSegment(
            segmentDescriptor.segmentId,
            segmentDescriptor.objectId,
            segmentDescriptor.start,
            segmentDescriptor.end,
            segmentDescriptor.startabs,
            segmentDescriptor.endabs,
            segmentDescriptor.sequenceNumber,
            segmentDescriptor.count,
            score
        )
    }
}
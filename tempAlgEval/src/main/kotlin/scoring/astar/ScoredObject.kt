package scoring.astar

import json.SegmentDescriptor

class ScoredObject(val objectId: String) {
    val segments = HashMap<String, Segment>()

    fun addSegment(segmentDescriptor: SegmentDescriptor) {
        if (segmentDescriptor.objectId == objectId) {
            segments[segmentDescriptor.segmentId] =
                (Segment(segmentDescriptor))
        }
    }

    fun addSegmentWeight(
        segmentId: String,
        weight: Float,
        containerId: Int
    ) {
        if (segments.containsKey(segmentId)) {
            segments[segmentId]?.addWeight(containerId, weight)
        }
    }

    fun getSuccessorsForContainerId(containerId: Int): ArrayList<Segment> {
        val tmpArrayList = arrayListOf<Segment>()
        segments.forEach { (_, segment) ->
            run {
                if (segment.hasScoreAfterContainerId(containerId)) {
                    tmpArrayList.add(segment)
                }
            }
        }
        return tmpArrayList
    }

    fun updateWeights() {
        segments.forEach { (_, u) -> u.updateWeights() }
    }

    class Segment(val segmentDescriptor: SegmentDescriptor) {
        private val weights = HashMap<Int, SegmentWeight>()
        private var minValueInMap = Int.MAX_VALUE

        fun addWeight(containerId: Int, weight: Float) {
            if (weights.containsKey(containerId)) {
                weights[containerId]?.addWeight(weight)
            } else {
                val tmp = SegmentWeight()
                tmp.addWeight(weight)
                weights[containerId] = tmp
            }
        }

        fun getWeight(containerId: Int): Float {
            return if (weights.containsKey(containerId)) {
                weights[containerId]!!.getWeight()
            } else {
                0f
            }
        }

        fun hasScoreAfterContainerId(containerId: Int): Boolean {
            return weights.containsKey(containerId + 1)
        }

        fun updateWeights() {
            weights.forEach { (_, u) -> u.averagePoolWeights() }
            minValueInMap = weights.keys.minOf { it }
        }

        fun getMinContainerValue(): Int {
            return minValueInMap
        }

        override fun toString(): String {
            return "Segment(segmentDescriptor=$segmentDescriptor, weights=$weights, minValueInMap=$minValueInMap)"
        }


        private class SegmentWeight {
            private var weight = 0.0f
            private var nrWeights = 0

            fun addWeight(w: Float) {
                weight += w
                nrWeights++
            }

            fun averagePoolWeights() {
                weight /= nrWeights
            }

            fun getWeight(): Float {
                return weight
            }

            override fun toString(): String {
                return "SegmentWeight(weight=$weight, nrWeights=$nrWeights)"
            }
        }
    }
}

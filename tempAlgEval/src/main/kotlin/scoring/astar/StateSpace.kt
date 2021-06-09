package scoring.astar

class StateSpace(private val nContainers: Int) {

    fun isGoal(
        s_: State,
        successors: ArrayList<ActionStatePair>
    ): Boolean {
        return s_.equals(0f) || s_.nContainersLeft == 0 || successors.size == 0
    }

    fun succ(
        s_: State,
        objectStorage: ScoredObject,
        timeDistanceTo: Float
    ): ArrayList<ActionStatePair> {
        val successors =
            objectStorage.getSuccessorsForContainerId(s_.containerId)
        val successorActionStatePairs = arrayListOf<ActionStatePair>()
        successors.forEach {
            if (!(it.segmentDescriptor.end < s_.getLastSegment().segmentDescriptor.start)) {
                val path = ArrayList<ScoredObject.Segment>()
                path.addAll(s_.getPath())
                path.add(it)
                successorActionStatePairs.add(
                    ActionStatePair(
                        Action(it.segmentDescriptor.startabs - s_.getLastSegment().segmentDescriptor.endabs),
                        State(
                            path,
                            timeDistanceTo,
                            s_.containerId + 1,
                            nContainers
                        )
                    )
                )
            }
        }
        return successorActionStatePairs
    }
}

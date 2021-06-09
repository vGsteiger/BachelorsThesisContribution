package scoring.astar

import json.CineastConstants
import json.QueryStorage
import json.Result
import json.ResultScoreTuple
import json.SegmentDescriptor
import json.SegmentQueryResult
import json.SimilarityQueryResult
import org.slf4j.LoggerFactory
import scoring.ScoringAlgorithm
import java.util.*

/**
 * Implementation of the a star temporal scoring algorithm as described in the thesis.
 */
class AStarScoringAlgorithm :
    ScoringAlgorithm() {
    override val algorithmId: String = "ASTAR"
    private val logger = LoggerFactory.getLogger(javaClass)
    private val objectStorage = HashMap<String, ScoredObject>()
    private val tmpSegmentStorage =
        mutableListOf<SegmentDescriptor>()
    private val tmpSimilarityStorage =
        mutableListOf<SimilarityQueryResult>()
    private var responseExtractionTime = 0L
    private var segmentAllocationTime = 0L
    private var similarityAllocationTime = 0L
    private var updateObjectsTime = 0L
    private var resultCreationTime = 0L
    private var allocationTime = 0L

    override fun scoreInternal(
        queryStorage: QueryStorage,
        timeDistances: ArrayList<Int>
    ): ResultScoreTuple {
        // Extracting the responses from cineast
        for (response in queryStorage.responses) {
            when (response.messageType) {
                CineastConstants.OBJECTQUERYRESULT -> continue
                CineastConstants.SEGMENTQUERYRESULT -> run {
                    response as SegmentQueryResult
                    tmpSegmentStorage.addAll(response.content)
                }
                CineastConstants.SIMILARITYQUERYRESULT -> tmpSimilarityStorage.add(
                    response as SimilarityQueryResult
                )
                CineastConstants.QUERYEND -> continue
                CineastConstants.QUERYSTART -> continue
                else -> logger.error("Unknown message: ${response.messageType}")
            }
        }

        tmpSegmentStorage.forEach {
            if (!objectStorage.containsKey(it.objectId)) {
                objectStorage[it.objectId] = ScoredObject(it.objectId)
            }
        }

        var nContainers = 0

        // Segment allocation to the corresponding object storages:
        tmpSegmentStorage.forEach {
            objectStorage[it.objectId]?.addSegment(it)
        }


        // Similarity allocation to the corresponding object storages:
        tmpSimilarityStorage.forEach {
            it.content.forEach { segmentWeight ->
                objectStorage[segmentWeight.key.substring(0, 7)]?.addSegmentWeight(
                    segmentWeight.key,
                    segmentWeight.value,
                    it.containerId
                )
                nContainers = maxOf(nContainers, it.containerId)
            }
        }

        nContainers++
        objectStorage.forEach { (_, u) -> u.updateWeights() }

        val resultList = ArrayList<ArrayList<ScoredObject.Segment>>()

        objectStorage.forEach lit1@{ (_, scoredObject) ->
            scoredObject.segments.forEach lit2@{ (_, segment) ->
                run {
                    val stateSpace = StateSpace(nContainers)
                    val open = PriorityQueue<Node>()
                    val initState =
                        State(
                            arrayListOf(segment),
                            0f,
                            segment.getMinContainerValue(),
                            nContainers
                        )
                    if (initState.getHeuristic() < Float.MAX_VALUE) {
                        val initTimeDistance = arrayListOf<Int>()
                        if (timeDistances.size > 1) {
                            initTimeDistance.add(timeDistances[0])
                        }
                        open.add(
                            Node(
                                arrayListOf(),
                                initState,
                                initTimeDistance
                            )
                        )
                    } else {
                        return@lit1
                    }
                    var timeDistanceIndex = 0
                    val distances = HashMap<State, Float>()
                    while (!open.isEmpty()) {
                        val n = open.remove()
                        if (!distances.containsKey(n.state) || n.getCost() < distances[n.state]!!) {
                            distances[n.state] = n.getCost()
                            if (timeDistanceIndex == timeDistances.size) {
                                resultList.add(n.extractPath())
                                return@lit2
                            }
                            val successors = stateSpace.succ(
                                n.state,
                                scoredObject,
                                timeDistances[timeDistanceIndex].toFloat()
                            )
                            if (stateSpace.isGoal(
                                    n.state,
                                    successors
                                )
                            ) {
                                resultList.add(n.extractPath())
                                return@lit2
                            }
                            timeDistanceIndex += 1
                            open.clear()
                            if (timeDistanceIndex < timeDistances.size) {
                                successors.forEach {
                                    if (it.state.getHeuristic() < Float.MAX_VALUE) {
                                        val newN = makeNode(
                                            n.path,
                                            it,
                                            timeDistances.subList(
                                                0,
                                                timeDistanceIndex
                                            )
                                        )
                                        open.add(newN)
                                    }
                                }
                            } else {
                                if (
                                    timeDistanceIndex == timeDistances.size
                                ) {
                                    successors.forEach {
                                        if (it.state.getHeuristic() < Float.MAX_VALUE) {
                                            val newN = makeNode(
                                                n.path,
                                                it,
                                                timeDistances
                                            )
                                            open.add(newN)
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }


        val results = LinkedHashMap<Result, Float>()

        resultList.forEach {
            run {
                // We still have an issue with counting the scores!
                var score = 0f
                var containerId = it.first().getMinContainerValue()
                it.forEach { segment ->
                    score += segment.getWeight(containerId++)
                }
                score /= nContainers
                results[Result(
                    it[0].segmentDescriptor.objectId,
                    it[0].segmentDescriptor.startabs,
                    it[it.size - 1].segmentDescriptor.endabs
                )] = score
            }
        }

        val doubleResults = ArrayList<Result>()

        results.forEach { (result, score) ->
            results.forEach { (innerResult, innerScore) ->
                if (result != innerResult && score > innerScore && result.otherIsWithin(
                        innerResult
                    )
                ) {
                    doubleResults.add(innerResult)
                }
            }
        }

        doubleResults.forEach {
            results.remove(it)
        }

        return ResultScoreTuple(results)
    }

    private fun makeNode(
        pathTo: ArrayList<Action>,
        actionStatePair: ActionStatePair,
        timeToNext: MutableList<Int>
    ): Node {
        val path = ArrayList<Action>()
        path.addAll(pathTo)
        path.add(actionStatePair.action)
        return Node(path, actionStatePair.state, timeToNext)
    }

    inner class Node(
        val path: ArrayList<Action>,
        val state: State,
        val timeDistances: MutableList<Int>
    ) : Comparable<Node> {
        private val h: Float = state.getHeuristic()
        private val cost: Float

        init {
            var cost = 0f
            var i = 0
            for (a in path) {
                cost += a.cost(timeDistances[i++].toFloat())
            }
            this.cost = cost
        }

        fun extractPath(): ArrayList<ScoredObject.Segment> {
            return this.state.getPath()
        }

        fun getCost(): Float {
            return this.cost
        }

        private fun getHeuristic(): Float {
            return this.h
        }

        override fun toString(): String {
            var s = ""
            s += "State: $state\n"
            s += "Path: $path\n"
            s += "Cost: ${this.cost}"
            return s
        }

        override fun compareTo(other: Node): Int {
            val res =
                (this.cost + this.h).compareTo(other.getCost() + other.getHeuristic())
            return if (res == 0) {
                this.h.compareTo(other.getHeuristic())
            } else {
                res
            }
        }
    }

    override fun logMeasurements(timesExecuted: Int) {
        super.logMeasurements(timesExecuted)
        logger.info("Response extraction took: ${responseExtractionTime / timesExecuted}")
        logger.info("Allocation time total: ${allocationTime / timesExecuted}")
        logger.info("Segment allocation took: ${segmentAllocationTime / timesExecuted}")
        logger.info("Similarity allocation took: ${similarityAllocationTime / timesExecuted}")
        logger.info("Time to update all object scores: ${updateObjectsTime / timesExecuted}")
        logger.info("Time to create results: ${resultCreationTime / timesExecuted}")
    }

    override fun clear() {
        objectStorage.clear()
        tmpSegmentStorage.clear()
        tmpSimilarityStorage.clear()
    }
}

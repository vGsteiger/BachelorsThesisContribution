package scoring.sequential

import json.CineastConstants
import json.QueryStorage
import json.Result
import json.ResultScoreTuple
import json.SegmentDescriptor
import json.SegmentQueryResult
import json.SegmentWeight
import json.SimilarityQueryResult
import org.slf4j.LoggerFactory
import scoring.ScoringAlgorithm
import java.util.*
import kotlin.math.max

/**
 * Implementation of the sequential temporal scoring algorithm as described in the thesis.
 */
class SequentialScoringAlgorithm : ScoringAlgorithm() {
    override val algorithmId: String = "SQA"
    private val logger = LoggerFactory.getLogger(javaClass)
    private val tmpSegmentStorage = HashMap<String, SegmentDescriptor>()
    private val tmpSimilarityQueryResultStorage = HashMap<Int, ArrayList<SegmentWeight>>()
    private val scoredSegmentLists = HashMap<String, HashMap<Int, SortedList>>()
    private var maxContainerId = -1

    override fun scoreInternal(
        queryStorage: QueryStorage,
        timeDistances: ArrayList<Int>
    ): ResultScoreTuple {
        queryStorage.responses.forEach { response ->
            run {
                when (response.messageType) {
                    CineastConstants.OBJECTQUERYRESULT -> run {
                        return@forEach
                    }
                    CineastConstants.SEGMENTQUERYRESULT -> {
                        response as SegmentQueryResult
                        response.content.forEach {
                            tmpSegmentStorage[it.segmentId] = it
                        }
                    }
                    CineastConstants.SIMILARITYQUERYRESULT -> run {
                        response as SimilarityQueryResult
                        this.maxContainerId = max(maxContainerId, response.containerId)
                        response.content.forEach {
                            if (tmpSimilarityQueryResultStorage.containsKey(response.containerId)) {
                                tmpSimilarityQueryResultStorage[response.containerId]!!.add(it)
                            } else {
                                tmpSimilarityQueryResultStorage[response.containerId] = arrayListOf(it)
                            }
                        }
                    }
                    CineastConstants.QUERYEND -> return@forEach
                    CineastConstants.QUERYSTART -> return@forEach
                    else -> logger.error("Unknown message: ${response.messageType}")
                }
            }
        }

        tmpSimilarityQueryResultStorage.forEach { (containerId, segmentWeights) ->
            segmentWeights.forEach { segmentWeight ->
                if (tmpSegmentStorage.containsKey(segmentWeight.key)) {
                    val segmentDescriptor = tmpSegmentStorage[segmentWeight.key]!!
                    addToScoredSegmentLists(segmentDescriptor.objectId, containerId, segmentWeight, segmentDescriptor)
                } else {
                    logger.debug("Segment not in responses!")
                }
            }
        }

        val bestPaths = ArrayList<Path>()

        scoredSegmentLists.forEach { (objectId, containerMaps) ->
            containerMaps.forEach { (containerId, sortedList) ->
                sortedList.forEach {
                    bestPaths.add(getBestPathForSegment(objectId, it, containerId))
                }
            }
        }

        val results = LinkedHashMap<Result, Float>()

        bestPaths.forEach {
            val startEndScore = it.getStartEndScore()
            val tmpScore = startEndScore.score / (maxContainerId + 1)
            results[Result(it.objectId, startEndScore.startAbs, startEndScore.endAbs)] = tmpScore
        }

        return ResultScoreTuple(results)
    }

    private fun getBestPathForSegment(objectId: String, scoredSegment: ScoredSegment, containerId: Int): Path {
        val compareByScore: Comparator<Path> = compareBy { it.getScore() }
        val pathQueue = PriorityQueue(compareByScore)

        val initPath = Path(objectId, scoredSegment, containerId)
        var bestPath = initPath

        pathQueue.add(initPath)

        while (!pathQueue.isEmpty()) {
            val path = pathQueue.remove()
            if (path.getCurrentContainerId() == maxContainerId) {
                if (path.getScore() > bestPath.getScore()) {
                    bestPath = path
                }
            } else if (path.getCurrentContainerId() < maxContainerId) {
                val lastHighestItem = path.getHighestCurrentItem()
                if (scoredSegmentLists.containsKey(objectId)) {
                    val currentContainerId = path.getCurrentContainerId() + 1
                    if (scoredSegmentLists[objectId]!!.containsKey(currentContainerId)) {
                        val followingItems =
                            scoredSegmentLists[objectId]!![currentContainerId]!!.getListFromElement(lastHighestItem)
                        followingItems.forEach {
                            val pathCopy = path.getCopy()
                            val tmpPath = Path(pathCopy.objectId, pathCopy.initSegment, pathCopy.initContainerId)
                            tmpPath.setCurrentContainerId(pathCopy.currentContainerId)
                            tmpPath.setScore(pathCopy.score)
                            tmpPath.setSegments(pathCopy.segments)
                            tmpPath.addSegment(it, currentContainerId)
                            pathQueue.add(tmpPath)
                        }
                    }
                }
            } else {
                logger.error("Container id of path higher than maxContainerId")
                continue
            }
        }

        return bestPath
    }

    private fun addToScoredSegmentLists(
        objectId: String,
        containerId: Int,
        segment: SegmentWeight,
        segmentDescriptor: SegmentDescriptor
    ) {
        val scoredSegment = ScoredSegment(segment.key, segment.value, segmentDescriptor)
        if (scoredSegmentLists.containsKey(objectId)) {
            if (scoredSegmentLists[objectId]!!.containsKey(containerId)) {
                val tmpIndex = scoredSegmentLists[objectId]!![containerId]!!.indexOfSegmentweight(segment)
                if (tmpIndex >= 0) {
                    scoredSegmentLists[objectId]!![containerId]!![tmpIndex].addScore(segment)
                } else {
                    scoredSegmentLists[objectId]!![containerId]!!.add(scoredSegment)
                }
            } else {
                scoredSegmentLists[objectId]!![containerId] = SortedList(arrayListOf(scoredSegment))
            }
        } else {
            scoredSegmentLists[objectId] = hashMapOf(containerId to SortedList(arrayListOf(scoredSegment)))
        }
    }

    override fun clear() {
        tmpSegmentStorage.clear()
        tmpSimilarityQueryResultStorage.clear()
        scoredSegmentLists.clear()
    }
}

package scoring.normal

import json.CineastConstants
import json.QueryResult
import json.QueryStorage
import json.Result
import json.ResultScoreTuple
import json.SegmentDescriptor
import json.SegmentQueryResult
import json.SegmentWeight
import json.SimilarityQueryResult
import org.slf4j.LoggerFactory
import scoring.ScoringAlgorithm
import kotlin.math.abs
import kotlin.math.exp
import kotlin.math.max
import kotlin.math.pow
import kotlin.math.sqrt

/**
 * Implementation of the normal temporal scoring algorithm as described in the thesis.
 */
class NormalScoringAlgorithm : ScoringAlgorithm() {
    override val algorithmId: String = "NA"
    private val logger = LoggerFactory.getLogger(javaClass)
    private val tmpSegmentStorage = HashMap<String, SegmentDescriptor>()
    private val scoredSegmentsLists = HashMap<String, HashMap<Int, SortedList>>()
    private val tmpSimilarityQueryResultStorage = HashMap<Int, ArrayList<SegmentWeight>>()
    private var timeDistancesInternal = ArrayList<Int>()
    private var maxContainerId = 0

    override fun scoreInternal(
        queryStorage: QueryStorage,
        timeDistances: ArrayList<Int>
    ): ResultScoreTuple {
        this.timeDistancesInternal = ArrayList(timeDistances.toList())

        queryStorage.responses.forEach { response ->
            assignResponse(response)
        }

        tmpSimilarityQueryResultStorage.forEach { (containerId, segmentWeights) ->
            segmentWeights.forEach { segmentWeight ->
                assignScoredSegmentsLists(containerId, segmentWeight)
            }
        }

        val results = LinkedHashMap<Result, Float>()

        scoredSegmentsLists.forEach { (objectId, containerMap) ->
            for (containerId in 0..maxContainerId) {
                if (containerMap.containsKey(containerId)) {
                    val sortedList = containerMap[containerId]!!
                    sortedList.forEach { scoredSegment ->
                        if (tmpSegmentStorage.containsKey(scoredSegment.segmentId)) {
                            val segmentDescription = tmpSegmentStorage[scoredSegment.segmentId]
                            val bestEndAndScore =
                                getBestEndAndScore(objectId, scoredSegment, containerId, maxContainerId)
                            results[Result(objectId, segmentDescription!!.startabs, bestEndAndScore.endAbs)] =
                                bestEndAndScore.score
                        }
                    }
                }
            }
        }

        return ResultScoreTuple(results)
    }

    private fun getBestEndAndScore(
        objectId: String,
        item: ScoredSegment,
        containerId: Int,
        maxContainerId: Int
    ): EndAndScore {
        val currentDescription = tmpSegmentStorage[item.segmentId]
        var score = item.getScore()
        var endAbs = currentDescription!!.endabs
        var currentSegment = item
        var currentEndTime = endAbs
        for (innerContainerId in containerId + 1..maxContainerId) {
            if (scoredSegmentsLists[objectId]!!.containsKey(innerContainerId)) {
                val listFromElement =
                    scoredSegmentsLists[objectId]!![innerContainerId]!!.getListFromElement(currentSegment)
                var bestItem = ScoredSegment("NONE", 0f)
                var bestScore = 0f
                listFromElement.forEach {
                    if (tmpSegmentStorage.containsKey(it.segmentId)) {
                        val tmpSegmentDescriptor = tmpSegmentStorage[it.segmentId]!!
                        val tmpScore = calculateNormalScore(
                            currentEndTime,
                            it,
                            timeDistancesInternal[innerContainerId - 1],
                            tmpSegmentDescriptor
                        )
                        if (tmpScore > bestScore) {
                            bestItem = it
                            bestScore = tmpScore
                        }
                    }
                }
                if (bestItem.segmentId != "NONE") {
                    currentSegment = bestItem
                    currentEndTime = tmpSegmentStorage[bestItem.segmentId]!!.endabs
                } else {
                    currentEndTime += timeDistancesInternal[innerContainerId - 1]
                }
                score += bestScore
            }
        }
        score /= maxContainerId + 1
        if (tmpSegmentStorage.containsKey(currentSegment.segmentId)) {
            val endDescription = tmpSegmentStorage[currentSegment.segmentId]
            endAbs = endDescription!!.endabs
        }
        return EndAndScore(endAbs, score)
    }

    private fun calculateNormalScore(
        currentSegmentEndTime: Float,
        nextSegment: ScoredSegment,
        timeDifference: Int,
        segmentDescriptor: SegmentDescriptor
    ): Float {
        val x = abs(segmentDescriptor.startabs - currentSegmentEndTime)
        val m = timeDifference.toFloat()
        var score = ((1f / (2f * sqrt(2f * Math.PI))) * exp((-1f / 2f) * ((x - m) / 2f).pow(2f))) * 5f
        score *= nextSegment.getScore()
        return score.toFloat()
    }

    private fun assignScoredSegmentsLists(containerId: Int, segmentWeight: SegmentWeight) {
        if (tmpSegmentStorage.containsKey(segmentWeight.key)) {
            val objectId = tmpSegmentStorage[segmentWeight.key]!!.objectId
            if (scoredSegmentsLists.containsKey(objectId)) {
                if (scoredSegmentsLists[objectId]!!.containsKey(containerId)) {
                    val tmpIndex = scoredSegmentsLists[objectId]!![containerId]!!.indexOfSegmentWeight(segmentWeight)
                    if (tmpIndex >= 0) {
                        scoredSegmentsLists[objectId]!![containerId]!![tmpIndex].addScore(segmentWeight)
                    } else {
                        scoredSegmentsLists[objectId]!![containerId]!!.add(
                            ScoredSegment(
                                segmentWeight.key,
                                segmentWeight.value
                            )
                        )
                    }
                } else {
                    scoredSegmentsLists[objectId]!![containerId] =
                        SortedList(arrayListOf(ScoredSegment(segmentWeight.key, segmentWeight.value)))
                }
            } else {
                scoredSegmentsLists[objectId] =
                    hashMapOf(
                        containerId to SortedList(
                            arrayListOf(
                                ScoredSegment(
                                    segmentWeight.key,
                                    segmentWeight.value
                                )
                            )
                        )
                    )
            }
        } else {
            logger.debug("Missing segment!")
            return
        }
    }

    private fun assignResponse(response: QueryResult) {
        when (response.messageType) {
            CineastConstants.OBJECTQUERYRESULT -> run {
                return
            }
            CineastConstants.SEGMENTQUERYRESULT -> {
                response as SegmentQueryResult
                response.content.forEach {
                    tmpSegmentStorage[it.segmentId] = it
                }
            }
            CineastConstants.SIMILARITYQUERYRESULT -> run {
                response as SimilarityQueryResult
                maxContainerId = max(maxContainerId, response.containerId)
                response.content.forEach {
                    if (tmpSimilarityQueryResultStorage.containsKey(response.containerId)) {
                        tmpSimilarityQueryResultStorage[response.containerId]!!.add(it)
                    } else {
                        tmpSimilarityQueryResultStorage[response.containerId] = arrayListOf(it)
                    }
                }
            }
            CineastConstants.QUERYEND -> return
            CineastConstants.QUERYSTART -> return
            else -> logger.error("Unknown message: ${response.messageType}")
        }

    }

    override fun clear() {
        tmpSegmentStorage.clear()
        scoredSegmentsLists.clear()
        tmpSimilarityQueryResultStorage.clear()
        timeDistancesInternal.clear()
    }
}

package scoring.inverseDecay

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
import kotlin.collections.set
import kotlin.math.exp
import kotlin.math.max

/**
 * Implementation of the inverse decay temporal scoring algorithm as described in the thesis.
 */
class InverseDecayScoringAlgorithm : ScoringAlgorithm() {
    private val logger = LoggerFactory.getLogger(javaClass)
    override val algorithmId: String = "IDA"
    private val tmpSegmentStorage = HashMap<String, SegmentDescriptor>()
    private val scoredSegmentsLists = HashMap<String, HashMap<Int, SortedList>>()
    private val tmpSimilarityQueryResultStorage = HashMap<Int, ArrayList<SegmentWeight>>()
    private var timeDistancesInternal = ArrayList<Int>()

    override fun scoreInternal(
        queryStorage: QueryStorage,
        timeDistances: ArrayList<Int>
    ): ResultScoreTuple {
        this.timeDistancesInternal = ArrayList(timeDistances.toList())

        var maxContainerId = 0
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
                        maxContainerId = max(maxContainerId, response.containerId)
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
            segmentWeights.forEach lit@{
                if (tmpSegmentStorage.containsKey(it.key)) {
                    val objectId = tmpSegmentStorage[it.key]!!.objectId
                    if (scoredSegmentsLists.containsKey(objectId)) {
                        if (scoredSegmentsLists[objectId]!!.containsKey(containerId)) {
                            val tmpIndex = scoredSegmentsLists[objectId]!![containerId]!!.indexOfSegmentweight(it)
                            if (tmpIndex >= 0) {
                                scoredSegmentsLists[objectId]!![containerId]!![tmpIndex].addScore(it)
                            } else {
                                scoredSegmentsLists[objectId]!![containerId]!!.add(ScoredSegment(it.key, it.value))
                            }
                        } else {
                            scoredSegmentsLists[objectId]!![containerId] =
                                SortedList(arrayListOf(ScoredSegment(it.key, it.value)))
                        }
                    } else {
                        scoredSegmentsLists[objectId] =
                            hashMapOf(containerId to SortedList(arrayListOf(ScoredSegment(it.key, it.value))))
                    }
                } else {
                    logger.debug("Missing segment!")
                    return@lit
                }
            }
        }

        val results = LinkedHashMap<Result, Float>()

        scoredSegmentsLists.forEach { (objectId, containerMap) ->
            for (containerId in 0..maxContainerId) {
                if (containerMap.containsKey(containerId)) {
                    val sortedList = containerMap[containerId]!!
                    sortedList.forEach {
                        if (tmpSegmentStorage.containsKey(it.segmentId)) {
                            val segmentDescription = tmpSegmentStorage[it.segmentId]
                            val bestEndAndScore = getBestEndAndScore(objectId, it, containerId, maxContainerId)
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
                        val tmpScore = calculateInverseDecayScore(
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

    private fun calculateInverseDecayScore(
        currentSegmentEndTime: Float,
        nextSegment: ScoredSegment,
        timeDifference: Int,
        segmentDescriptor: SegmentDescriptor
    ): Float {
        var score = 0f
        if (segmentDescriptor.startabs >= currentSegmentEndTime && segmentDescriptor.startabs < currentSegmentEndTime + timeDifference.toFloat()) {
            score =
                exp((0.1f * (segmentDescriptor.startabs - currentSegmentEndTime - timeDifference.toFloat())).toDouble())
                    .toFloat() * nextSegment.getScore()
        } else if (segmentDescriptor.startabs >= currentSegmentEndTime && segmentDescriptor.startabs > currentSegmentEndTime + timeDifference.toFloat()) {
            score =
                exp((-0.1f * (segmentDescriptor.startabs - currentSegmentEndTime - timeDifference.toFloat())).toDouble())
                    .toFloat() * nextSegment.getScore()
        } else if (segmentDescriptor.startabs == currentSegmentEndTime + timeDifference.toFloat()) {
            score = nextSegment.getScore()
        }
        return score
    }

    override fun clear() {
        tmpSegmentStorage.clear()
        scoredSegmentsLists.clear()
        tmpSimilarityQueryResultStorage.clear()
        timeDistancesInternal.clear()
    }
}

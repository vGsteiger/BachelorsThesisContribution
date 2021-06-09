package scoring.simple

import json.CineastConstants.OBJECTQUERYRESULT
import json.CineastConstants.QUERYEND
import json.CineastConstants.QUERYSTART
import json.CineastConstants.SEGMENTQUERYRESULT
import json.CineastConstants.SIMILARITYQUERYRESULT
import json.ObjectQueryResult
import json.QueryStorage
import json.Result
import json.ResultScoreTuple
import json.ScoreSegmentTuple
import json.SegmentMap
import json.SegmentQueryResult
import json.SimilarityQueryResult
import org.slf4j.LoggerFactory
import scoring.ScoringAlgorithm
import utils.EmptyTimeDistancesException
import utils.ObjectNotPresentException
import java.util.*

/**
 * Implementation of the simple temporal scoring algorithm as described in the thesis.
 */
class SimpleScoringAlgorithm : ScoringAlgorithm() {
    override val algorithmId: String = "STA"
    private val similarityResultMap = HashMap<Int, SimResultContainerStorage>()
    private val objectSegmentMap = HashMap<String, SegmentMap>()
    private val tmpObjectStorage = mutableListOf<ObjectQueryResult>()
    private val tmpSegmentStorage =
        mutableListOf<SegmentQueryResult>()
    private val tmpSimilarityStorage =
        mutableListOf<SimilarityQueryResult>()
    private var nrTemporalQueries = 0
    private val logger = LoggerFactory.getLogger(javaClass)
    private var firstError = false

    override fun scoreInternal(
        queryStorage: QueryStorage,
        timeDistances: ArrayList<Int>
    ): ResultScoreTuple {
        firstError = false
        for (response in queryStorage.responses) {
            when (response.messageType) {
                OBJECTQUERYRESULT -> tmpObjectStorage.add(
                    response as ObjectQueryResult
                )
                SEGMENTQUERYRESULT -> tmpSegmentStorage.add(
                    response as SegmentQueryResult
                )
                SIMILARITYQUERYRESULT -> tmpSimilarityStorage.add(
                    response as SimilarityQueryResult
                )
                QUERYEND -> continue
                QUERYSTART -> continue
                else -> logger.error("Unknown message: ${response.messageType}")
            }
        }

        tmpObjectStorage.forEach {
            unpackObjectResult(it)
        }
        tmpSegmentStorage.forEach {
            unpackSegmentResult(it)
        }
        nrTemporalQueries = 0
        tmpSimilarityStorage.forEach {
            similarityResultMap[it.containerId] = SimResultContainerStorage()
            nrTemporalQueries = maxOf(nrTemporalQueries, it.containerId)
        }
        tmpSimilarityStorage.forEach {
            similarityResultMap[it.containerId]?.unpackSimilarityResult(it)
        }
        nrTemporalQueries++

        if (timeDistances.size < nrTemporalQueries - 1) {
            throw EmptyTimeDistancesException("Wrong number of time distances")
        }
        val resultScoreTuple =
            ResultScoreTuple(LinkedHashMap<Result, Float>())
        objectSegmentMap.forEach {
            val segmentTopScoreMap = HashMap<String, Float>()
            val sortedMapList = mutableListOf<SortedMap<String, Float>>()
            for (s in similarityResultMap.values) {
                try {
                    val resultTmp = s.getOrderedScoresForObjectId(it.key)
                    sortedMapList.add(resultTmp)
                } catch (e: ObjectNotPresentException) {
                    continue
                }
            }
            val segmentLastSegmentMap = HashMap<String, String>()
            sortedMapList.forEachIndexed { index, element ->
                run {
                    element.forEach { (t, s) ->
                        run {
                            var walker = index + 1
                            var nextSegment = t
                            var i2 = 0
                            var score = s
                            while (walker < sortedMapList.size) {
                                val sortedMap =
                                    sortedMapList[walker++]
                                val tmpTuple =
                                    extractNextTemporalSequence(
                                        it.key,
                                        nextSegment,
                                        sortedMap,
                                        timeDistances[i2].toFloat()
                                    )
                                if (tmpTuple.segment == "NONE") {
                                    break
                                } else {
                                    nextSegment = tmpTuple.segment
                                    score += tmpTuple.score
                                    i2++
                                }
                            }
                            segmentLastSegmentMap[t] = nextSegment
                            segmentTopScoreMap[t] =
                                score / nrTemporalQueries.toFloat()
                        }
                    }
                }
            }
            for ((k, v) in segmentTopScoreMap) {
                try {
                    val begin =
                        objectSegmentMap[it.key]!!.segments[k]!!.startabs
                    val end =
                        objectSegmentMap[it.key]!!.segments[segmentLastSegmentMap[k]]!!.endabs
                    val result = Result(
                        it.key,
                        begin,
                        end
                    )
                    resultScoreTuple.results[result] = v
                } catch (e: NullPointerException) {
                    if (!firstError) {
                        firstError = true
                        logger.error(e.toString())
                    }
                    continue
                }
            }
        }

        return resultScoreTuple
    }

    private fun extractNextTemporalSequence(
        objectId: String,
        currentSegment: String,
        nextQuerySortedMap: SortedMap<String, Float>,
        timeToNext: Float
    ): ScoreSegmentTuple {
        val currentSegmentEnd: Float
        try {
            currentSegmentEnd =
                objectSegmentMap[objectId]!!.segments[currentSegment]!!.endabs
        } catch (e: NullPointerException) {
            if (!firstError) {
                firstError = true
                logger.error(e.toString())
            }
            return ScoreSegmentTuple(0f, "NONE")
        }
        val topSegment = currentSegmentEnd + timeToNext
        var currentTopScore = 0f
        var bestSegment = "NONE"
        for ((k, v) in nextQuerySortedMap) {
            try {
                if (k <= currentSegment) {
                    continue
                } else if (objectSegmentMap[objectId]!!.segments[k]!!.startabs > topSegment) {
                    continue
                } else {
                    if (v > currentTopScore) {
                        currentTopScore = v
                        bestSegment = k
                    }
                }
            } catch (e: NullPointerException) {
                if (!firstError) {
                    firstError = true
                    logger.error(e.toString())
                }
                continue
            }
        }
        return ScoreSegmentTuple(currentTopScore, bestSegment)
    }

    private fun unpackObjectResult(objectQueryResult: ObjectQueryResult) {
        for (o in objectQueryResult.content) {
            objectSegmentMap[o.objectId] = SegmentMap(hashMapOf())
        }
    }

    private fun unpackSegmentResult(segmentQueryResult: SegmentQueryResult) {
        segmentQueryResult.content.forEach { s ->
            if (objectSegmentMap.containsKey(s.objectId)) {
                objectSegmentMap[s.objectId]?.segments?.set(s.segmentId, s)
            } else {
                objectSegmentMap[s.objectId] =
                    SegmentMap(hashMapOf(s.segmentId to s))
            }
        }
    }

    override fun clear() {
        similarityResultMap.clear()
        objectSegmentMap.clear()
        tmpObjectStorage.clear()
        tmpSegmentStorage.clear()
        tmpSimilarityStorage.clear()
        nrTemporalQueries = 0
        firstError = false
    }
}

package scoring.cluster

import json.CineastConstants
import json.ObjectQueryResult
import json.QueryStorage
import json.Result
import json.ResultScoreTuple
import json.SegmentDescriptor
import json.SegmentQueryResult
import json.SimilarityQueryResult
import org.slf4j.LoggerFactory
import scoring.ScoringAlgorithm
import kotlin.math.max

/**
 * Implementation of the cluster temporal scoring algorithm as described in the thesis.
 */
class ClusterScoringAlgorithm : ScoringAlgorithm() {
    private val logger = LoggerFactory.getLogger(javaClass)
    override val algorithmId: String = "CLUSTER"
    private val tmpObjectStorage = mutableListOf<String>()
    private val tmpSegmentStorage =
        HashMap<String, HashMap<String, SegmentDescriptor>>()
    private val tmpSimilarityQueryResultStorage = ArrayList<SimilarityQueryResult>()
    private val tmpSimilarityStorage =
        HashMap<String, HashMap<Int, ArrayList<ScoredSegment>>>()
    private var queryContainerCount = 0
    private val objectQueryClusters =
        HashMap<String, HashMap<Int, ArrayList<Cluster>>>()
    private var timeDistances = ArrayList<Int>()
    private val clusterDistance = 2f

    override fun scoreInternal(
        queryStorage: QueryStorage,
        timeDistances: ArrayList<Int>
    ): ResultScoreTuple {
        this.timeDistances = timeDistances
        queryStorage.responses.forEach { response ->
            run {
                when (response.messageType) {
                    CineastConstants.OBJECTQUERYRESULT -> run {
                        response as ObjectQueryResult
                        response.content.forEach {
                            tmpObjectStorage.add(it.objectId)
                        }
                    }
                    CineastConstants.SEGMENTQUERYRESULT -> {
                        response as SegmentQueryResult
                        response.content.forEach {
                            if (!tmpSegmentStorage.containsKey(it.segmentId)) {
                                tmpSegmentStorage[it.segmentId] = hashMapOf(it.segmentId to it)
                            } else {
                                tmpSegmentStorage[it.segmentId]!![it.segmentId] = it
                            }
                        }
                    }
                    CineastConstants.SIMILARITYQUERYRESULT -> run {
                        response as SimilarityQueryResult
                        tmpSimilarityQueryResultStorage.add(response)
                    }
                    CineastConstants.QUERYEND -> return@forEach
                    CineastConstants.QUERYSTART -> return@forEach
                    else -> logger.error("Unknown message: ${response.messageType}")
                }
            }
        }

        val scoredSegmentFactory = ScoredSegmentFactory()

        tmpSimilarityQueryResultStorage.forEach {
            queryContainerCount = max((it).containerId, queryContainerCount)
            it.content.forEach { segmentWeight ->
                val objectId = segmentWeight.key.substring(0, 7)
                val segmentDescriptor = tmpSegmentStorage[segmentWeight.key]?.get(segmentWeight.key)
                if (segmentDescriptor != null) {
                    if (!tmpSimilarityStorage.containsKey(objectId)) {
                        tmpSimilarityStorage[objectId] = hashMapOf(
                            it.containerId to arrayListOf(
                                scoredSegmentFactory.createScoredSegment(
                                    segmentDescriptor,
                                    segmentWeight.value
                                )
                            )
                        )
                    } else {
                        if (!tmpSimilarityStorage[objectId]!!.containsKey(it.containerId)
                        ) {
                            tmpSimilarityStorage[objectId]!![it.containerId] = arrayListOf(
                                scoredSegmentFactory.createScoredSegment(
                                    segmentDescriptor,
                                    segmentWeight.value
                                )
                            )
                        } else {
                            tmpSimilarityStorage[objectId]!![it.containerId]!!.add(
                                scoredSegmentFactory.createScoredSegment(
                                    segmentDescriptor,
                                    segmentWeight.value
                                )
                            )
                        }
                    }
                } else {
                    logger.debug("Segment ${segmentWeight.key} of object $objectId not present in segment storage")
                }
            }
        }

        tmpSimilarityStorage.forEach { (objectId, containerMap) ->
            containerMap.forEach { (containerId, scoredSegments) ->
                run {
                    val clusters = ArrayList<Cluster>()
                    val sortedScoredSegments = scoredSegments.sortedWith(compareBy { it.startabs })

                    var clusterIter = 0
                    sortedScoredSegments.forEach {
                        if (clusters.size < 1) {
                            clusters.add(Cluster(it.objectId, it.startabs, it.endabs, it.score))
                        } else {
                            if (clusters[clusterIter].getEndAbs() + clusterDistance >= it.startabs) {
                                clusters[clusterIter].addSegment(it)
                            } else {
                                clusters.add(Cluster(it.objectId, it.startabs, it.endabs, it.score))
                                clusterIter++
                            }
                        }
                    }
                    if (objectQueryClusters.containsKey(objectId)) {
                        objectQueryClusters[objectId]!![containerId] = clusters
                    } else {
                        objectQueryClusters[objectId] = hashMapOf(containerId to clusters)
                    }
                }
            }
        }

        val results = LinkedHashMap<Result, Float>()

        objectQueryClusters.forEach { (_, containerMap) ->
            run {
                for (i in 0..queryContainerCount + 1) {
                    if (!containerMap.containsKey(i)) {
                        continue
                    } else {
                        containerMap[i]!!.forEach {
                            val result = getResultAndScore(it, containerMap, i)
                            if (result != null) {
                                results[result.result] = result.score
                            } else {
                                results[Result(it.objectId, it.getStartAbs(), it.getEndAbs())] =
                                    it.getScore()
                            }
                        }
                    }
                }
            }
        }

        return ResultScoreTuple(results)
    }

    private fun getResultAndScore(
        cluster: Cluster,
        containerMap: HashMap<Int, ArrayList<Cluster>>,
        currentContainerId: Int
    ): ResultAndScore? {
        val startAbs = cluster.getStartAbs()
        var score = cluster.getScore()
        var timeDistanceIter = 0

        if (timeDistances.size > 0) {
            var previousEndTime = cluster.getEndAbs()
            var nextStartTimeBefore = cluster.getEndAbs() + timeDistances[timeDistanceIter]
            var endAbs = cluster.getEndAbs()
            for (i in currentContainerId + 1..queryContainerCount + 1) {
                if (containerMap.containsKey(i)) {
                    val tmpCluster = getBestClusterWithinTime(containerMap[i]!!, nextStartTimeBefore, previousEndTime)
                    score += tmpCluster.getScore()
                    endAbs = tmpCluster.getEndAbs()
                    timeDistanceIter++
                    if (timeDistanceIter == timeDistances.size) {
                        break
                    }
                    if (tmpCluster.getScore() != 0f) {
                        nextStartTimeBefore = endAbs + timeDistances[timeDistanceIter]
                        previousEndTime = tmpCluster.getEndAbs()
                    } else {
                        nextStartTimeBefore += timeDistances[timeDistanceIter]
                    }
                }
            }

            score /= queryContainerCount + 1
            return ResultAndScore(Result(cluster.objectId, startAbs, endAbs), score)
        }
        return null
    }

    private fun getBestClusterWithinTime(
        clusters: ArrayList<Cluster>,
        nextStartTimeBefore: Float,
        previousEndTime: Float
    ): Cluster {
        var bestCluster = Cluster("None", 0f, previousEndTime, 0f)
        clusters.forEach {
            if (it.getStartAbs() in previousEndTime..nextStartTimeBefore && it.getScore() >= bestCluster.getScore()) {
                bestCluster = it
            }
        }
        return bestCluster
    }

    override fun clear() {
        tmpObjectStorage.clear()
        tmpSegmentStorage.clear()
        tmpSimilarityQueryResultStorage.clear()
        tmpSimilarityStorage.clear()
        queryContainerCount = 0
        objectQueryClusters.clear()
    }
}

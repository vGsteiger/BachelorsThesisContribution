package main

import evaluation.EvaluationProcessor
import json.CineastConstants
import json.OrderedResults
import json.QueryParameters
import json.QueryStorage
import json.Result
import json.SimilarityQueryResult
import json.Specifications
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.java_websocket.exceptions.WebsocketNotConnectedException
import org.slf4j.LoggerFactory
import query.QueryProcessor
import scoring.ScoringAlgorithm
import scoring.ScoringProcessor
import scoring.astar.AStarScoringAlgorithm
import scoring.cluster.ClusterScoringAlgorithm
import scoring.inverseDecay.InverseDecayScoringAlgorithm
import scoring.logNormal.LogNormalScoringAlgorithm
import scoring.normal.NormalScoringAlgorithm
import scoring.sequential.SequentialScoringAlgorithm
import scoring.simple.SimpleScoringAlgorithm
import scoring.vitrivr.VitrivrScoringAlgorithm
import utils.EmptyTimeDistancesException
import java.net.URI

/**
 * This is the main running part of the evaluation application where we start running the queries to Cineast, score the results and create the evaluation reports.
 */
class EvalApp(
    private val uri: URI,
    private val specifications: Specifications,
    evaluationPath: String
) {
    private val scoringProcessor: ScoringProcessor =
        ScoringProcessor()
    private var queryProcessor: QueryProcessor = QueryProcessor(uri)
    private val evaluationProcessor: EvaluationProcessor =
        EvaluationProcessor(evaluationPath)
    private val queryStorageMap: HashMap<String, QueryStorage> =
        HashMap()
    private val correctResultMap: HashMap<String, Result> = HashMap()
    private val parameterMap: HashMap<String, QueryParameters> =
        HashMap()
    private val logger = LoggerFactory.getLogger(javaClass)

    @Throws(EmptyTimeDistancesException::class)
    fun evaluate(retries: Int) {
        var r = retries
        try {
            queryProcessor.initiateQueries(specifications.tasks)
        } catch (e: WebsocketNotConnectedException) {
            logger.error("Connection unsuccessful")
            if (retries > 0) {
                Thread.sleep(6000)
                queryProcessor = QueryProcessor(uri)
                this.evaluate(--r)
            } else {
                throw WebsocketNotConnectedException()
            }
        }
        Thread.sleep(500)
        logger.info("Connection successfully established")

        for (t in specifications.tasks) {
            correctResultMap[t.config.queryId] = t.correctResult
            parameterMap[t.config.queryId] = QueryParameters(t.taskType, t.config.queryId)
        }

        scoringProcessor.addScoringAlgorithm(SimpleScoringAlgorithm())
        scoringProcessor.addScoringAlgorithm(VitrivrScoringAlgorithm())
        scoringProcessor.addScoringAlgorithm(AStarScoringAlgorithm())
        scoringProcessor.addScoringAlgorithm(ClusterScoringAlgorithm())
        scoringProcessor.addScoringAlgorithm(InverseDecayScoringAlgorithm())
        scoringProcessor.addScoringAlgorithm(LogNormalScoringAlgorithm())
        scoringProcessor.addScoringAlgorithm(NormalScoringAlgorithm())
        scoringProcessor.addScoringAlgorithm(SequentialScoringAlgorithm())

        runBlocking {
            val jobList = ArrayList<Job>()
            while (specifications.tasks.size > queryStorageMap.size) {
                val tmpMap = queryProcessor.retrieveCompleteQueries()

                if (tmpMap.isNotEmpty()) {
                    logger.info("Done ${queryStorageMap.size}/${specifications.tasks.size}")
                    for ((queryId, queryStorage) in tmpMap) {
                        if (!queryStorageMap.containsKey(queryId)) {
                            jobList.add(launch(Dispatchers.Default) {
                                val scoringAlgorithms: ArrayList<ScoringAlgorithm> = ArrayList()
                                scoringAlgorithms.add(SimpleScoringAlgorithm())
                                scoringAlgorithms.add(VitrivrScoringAlgorithm())
                                scoringAlgorithms.add(ClusterScoringAlgorithm())
                                scoringAlgorithms.add(InverseDecayScoringAlgorithm())
                                scoringAlgorithms.add(LogNormalScoringAlgorithm())
                                scoringAlgorithms.add(NormalScoringAlgorithm())
                                scoringAlgorithms.add(SequentialScoringAlgorithm())
                                logger.info("Currently working on query: $queryId")
                                queryStorageMap[queryId] = queryStorage
                                var timeDistances = arrayListOf<Int>()
                                for (task in specifications.tasks) {
                                    if (task.config.queryId == queryId) {
                                        timeDistances = ArrayList(task.timeDistances)
                                    }
                                }
                                logger.info("Scoring query: ${queryStorage.temporalQuery.config.queryId}")
                                try {
                                    val scoringAlgorithmMap: HashMap<String, OrderedResults> = HashMap()
                                    scoringAlgorithms.forEach { scoringAlgorithm ->
                                        logger.info("Scoring query: ${queryStorage.temporalQuery.config.queryId} with scoring algorithm: ${scoringAlgorithm.algorithmId}")
                                        val scoredResult = scoringAlgorithm.score(
                                            queryStorage,
                                            timeDistances
                                        )
                                        scoringAlgorithmMap[scoringAlgorithm.algorithmId] = scoredResult
                                    }

                                    val nrCineastResults = getNumberOfResults(queryStorage)

                                    for ((_, orderedResult) in scoringAlgorithmMap)
                                        correctResultMap[queryId]?.let {
                                            parameterMap[queryId]?.let { it1 ->
                                                evaluationProcessor.evaluate(
                                                    it,
                                                    orderedResult,
                                                    it1,
                                                    nrCineastResults
                                                )
                                            }
                                        }
                                } catch (e: OutOfMemoryError) {
                                    logger.error(e.toString())
                                }
                            })
                        }
                    }
                }
                Thread.sleep(500)
            }
            jobList.forEach { it.join() }
        }

        evaluationProcessor.cleanup()
        logger.info("Done Scoring!")
        return
    }

    private fun getNumberOfResults(queryStorage: QueryStorage): Int {
        val localList: MutableList<SimilarityQueryResult> = ArrayList()
        for (response in queryStorage.responses) {
            when (response.messageType) {
                CineastConstants.OBJECTQUERYRESULT -> continue
                CineastConstants.SEGMENTQUERYRESULT -> continue
                CineastConstants.SIMILARITYQUERYRESULT -> localList.add(
                    response as SimilarityQueryResult
                )
                CineastConstants.QUERYEND -> continue
                CineastConstants.QUERYSTART -> continue
                else -> logger.error("Unknown message: ${response.messageType}")
            }
        }
        var nrResults = 0
        for (response in localList) {
            nrResults += response.content.size
        }
        return nrResults
    }
}

package evaluation

import json.EvaluationResultContainer
import json.OrderedResults
import json.PrecisionRecall
import json.QuantitativeResults
import json.QueryParameters
import json.Result
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVPrinter
import org.slf4j.LoggerFactory
import java.io.BufferedWriter
import java.nio.file.Files
import java.nio.file.Paths

/**
 * Class to create evaluation files from the scoring result sets and store to csv
 */

class EvaluationProcessor(path: String) {
    private val evaluationMetrics = VBS2019(50f, 0.4f)
    private val containers: MutableList<EvaluationResultContainer> = mutableListOf()
    private val logger = LoggerFactory.getLogger(javaClass)
    private val prForAlgorithms = HashMap<String, HashMap<String, PrecisionRecall>>()
    private val writer: BufferedWriter
    private val csvPrinter: CSVPrinter
    private var objectCount = 0

    init {
        writer = Files.newBufferedWriter(Paths.get(path))
        csvPrinter = CSVPrinter(
            writer,
            CSVFormat.DEFAULT.withHeader(
                "TaskId",
                "TaskType",
                "AlgorithmId",
                "ScoringTime",
                "NumberTemporalQueries",
                "SearchedItemPosition",
                "SearchedObjectPositionSum",
                "TotalObjectResults",
                "FirstOccurrence",
                "TotalResults",
                "SearchedItemScore",
                "VBSScore",
                "AvgScore",
                "MedianScore",
                "BestScore",
                "WorstScore",
                "NumberCineastResults"
            )
        )
    }

    fun evaluate(
        correctResult: Result,
        orderedResults: OrderedResults,
        queryParameters: QueryParameters,
        numberOfCineastResults: Int
    ) {
        val vbsScore = evaluationMetrics.score(correctResult, orderedResults)

        //savePR(correctResult, orderedResults, queryParameters)

        val searchedItemPosition = getCorrectResultPosition(correctResult, orderedResults.results)
        val searchedItemScore = getCorrectResultScore(correctResult, orderedResults.results)
        val searchedObjectPositionSum = getCorrectObjectPositionSum(correctResult, orderedResults.results)
        val quantitativeResults = getQuantitativeResults(orderedResults.results, orderedResults.algorithmId)
        val firstOccurrence = getFirstOccurrence(correctResult, orderedResults.results)
        val numberTemporalQueries = Character.getNumericValue(queryParameters.taskId.last()) + 1
        val c = EvaluationResultContainer(
            queryParameters.taskId,
            queryParameters.taskType,
            orderedResults.algorithmId,
            orderedResults.scoringTime,
            numberTemporalQueries,
            searchedItemPosition,
            searchedObjectPositionSum,
            objectCount,
            firstOccurrence,
            orderedResults.results.size,
            searchedItemScore,
            vbsScore,
            quantitativeResults.average,
            quantitativeResults.median,
            quantitativeResults.best,
            quantitativeResults.worst,
            numberOfCineastResults
        )
        containers.add(c)
        resultsToCSV(c)
    }

    private fun resultsToCSV(c: EvaluationResultContainer) {
        csvPrinter.printRecord(
            c.taskId,
            c.taskType,
            c.algorithmId,
            c.scoringTime,
            c.numberOfTemporalQueries,
            c.searchedItemPosition,
            c.searchedObjectPositionSum,
            c.objectNr,
            c.firstOccurrence,
            c.totalItems,
            c.searchedItemScore,
            c.vbsScore,
            c.avgScore,
            c.medianScore,
            c.bestScore,
            c.worstScore,
            c.numberCineastResults
        )

    }

    fun cleanup() {
        csvPrinter.flush()
        csvPrinter.close()
    }

    fun printPRCSV(path: String) {
        prForAlgorithms.forEach { (algorithmId, prHashMap) ->
            prHashMap.forEach { (identifier, precisionRecall) ->
                val filePath = path.substringBeforeLast(".") + algorithmId + "-" + identifier + ".csv"
                val writer = Files.newBufferedWriter(Paths.get(filePath))
                val csvPrinter = CSVPrinter(
                    writer,
                    CSVFormat.DEFAULT.withHeader(
                        "precision",
                        "recall"
                    )
                )
                precisionRecall.precisionScores.forEachIndexed { index, fl ->
                    csvPrinter.printRecord(
                        fl,
                        precisionRecall.recallScores[index]
                    )
                }
                csvPrinter.flush()
                csvPrinter.close()
            }
        }
    }

    private fun getCorrectObjectPositionSum(result: Result, scoredList: HashMap<Result, Float>): Int {
        val objectScores = HashMap<String, Float>()
        scoredList.forEach { (result, score) ->
            if (objectScores.containsKey(result.V3C1ObjectId)) {
                objectScores[result.V3C1ObjectId] = score + objectScores[result.V3C1ObjectId]!!
            } else {
                objectScores[result.V3C1ObjectId] = score
            }
        }

        var breaked = false
        objectCount = objectScores.size
        var sortedResult = objectScores.toList().sortedBy { (_, value) -> value }
        sortedResult = sortedResult.reversed()
        var pos = -1
        for (r in sortedResult) {
            pos++
            if (r.first == result.V3C1ObjectId) {
                breaked = true
                break
            }
        }

        return if (breaked) {
            pos
        } else {
            -1
        }
    }

    private fun getCorrectResultPosition(result: Result, scoredList: HashMap<Result, Float>): Int {
        val tmp = HashMap(scoredList)
        var breaked = false
        var sortedResult = tmp.toList().sortedBy { (_, value) -> value }
        sortedResult = sortedResult.reversed()
        var pos = -1
        for (r in sortedResult) {
            pos++
            if (r.first.isSimilar(result, 15f)) {
                breaked = true
                break
            }
        }

        return if (breaked) {
            pos
        } else {
            -1
        }

    }

    private fun getCorrectResultScore(result: Result, scoredList: HashMap<Result, Float>): Float {
        val tmp = HashMap(scoredList)
        var sortedResult = tmp.toList().sortedBy { (_, value) -> value }
        sortedResult = sortedResult.reversed()
        var score = -1f
        for (r in sortedResult) {
            if (r.first.isSimilar(result, 30f)) {
                score = r.second
                break
            }
        }
        return score
    }

    private fun getFirstOccurrence(result: Result, scoredList: HashMap<Result, Float>): Int {
        val tmp = HashMap(scoredList)
        var breaked = false
        var sortedResult = tmp.toList().sortedBy { (_, value) -> value }
        sortedResult = sortedResult.reversed()
        var pos = -1
        for (r in sortedResult) {
            pos++
            if (r.first.V3C1ObjectId == result.V3C1ObjectId) {
                breaked = true
                break
            }
        }
        return if (breaked) {
            pos
        } else {
            -1
        }
    }

    private fun getQuantitativeResults(map: HashMap<Result, Float>, algorithmId: String): QuantitativeResults {
        val scoreList = ArrayList(map.values)
        val average = scoreList.average().toFloat()
        scoreList.sort()
        var median = -1f
        var worst = -1f
        var best = -1f
        try {
            median =
                if (scoreList.size % 2 == 0) {
                    (scoreList[(scoreList.size / 2)].toFloat() + (scoreList[scoreList.size / 2 - 1]) / 2)
                } else {
                    scoreList[(scoreList.size / 2)].toFloat()
                }
            worst = scoreList[0]
            best = scoreList[scoreList.size - 1]
        } catch (e: IndexOutOfBoundsException) {
            logger.error("Algorithm: $algorithmId: $e")
        }
        return QuantitativeResults(average, median, best, worst)
    }

    private fun savePR(correctResult: Result, orderedResults: OrderedResults, queryParameters: QueryParameters) {
        val tmp = HashMap(orderedResults.results)
        var sortedResult = tmp.toList().sortedBy { (_, value) -> value }
        sortedResult = sortedResult.reversed()
        val numberOfRelevantResults =
            sortedResult.count { it.first.V3C1ObjectId == correctResult.V3C1ObjectId }.toFloat()
        val precisionList = ArrayList<Float>()
        val recallList = ArrayList<Float>()
        var numberOfItems = 0f
        var numberOfCorrectItems = 0f
        sortedResult.forEach {
            numberOfItems += 1f
            if (it.first.V3C1ObjectId == correctResult.V3C1ObjectId) {
                numberOfCorrectItems += 1f
            }
            precisionList.add(numberOfCorrectItems / numberOfItems)
            recallList.add(numberOfCorrectItems / numberOfRelevantResults)
        }
        if (prForAlgorithms.containsKey(orderedResults.algorithmId)) {
            prForAlgorithms[orderedResults.algorithmId]!![queryParameters.taskId] =
                PrecisionRecall(precisionList, recallList)
        } else {
            prForAlgorithms[orderedResults.algorithmId] =
                hashMapOf(queryParameters.taskId to PrecisionRecall(precisionList, recallList))
        }
    }
}

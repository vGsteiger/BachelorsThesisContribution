package scoring

import json.OrderedResults
import json.QueryStorage
import json.ResultScoreTuple
import org.slf4j.LoggerFactory
import kotlin.system.measureNanoTime

/**
 * Abstract class from which every scoring algorithm has to inherit to ensure that all use the same interface
 */
abstract class ScoringAlgorithm {
    abstract val algorithmId: String
    private val logger = LoggerFactory.getLogger(javaClass)
    private var executionTime = 0L

    fun score(
        queryStorage: QueryStorage,
        timeDistances: ArrayList<Int>
    ): OrderedResults {
        var resultTuple: ResultScoreTuple
        logger.debug("Started Scoring")
        executionTime = measureNanoTime {
            resultTuple =
                scoreInternal(queryStorage, timeDistances)
        }
        logger.debug("Finished Scoring")
        val memory = 0L
        return OrderedResults(
            algorithmId,
            resultTuple.results,
            executionTime,
            memory
        )
    }

    protected abstract fun scoreInternal(
        queryStorage: QueryStorage,
        timeDistances: ArrayList<Int>
    ): ResultScoreTuple

    open fun logMeasurements(timesExecuted: Int) {
        logger.info("Total time of last execution: $executionTime")
    }

    abstract fun clear()
}

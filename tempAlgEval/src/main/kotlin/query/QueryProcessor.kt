package query

import json.QueryStorage
import json.SpecificationTask
import json.parsers.TemporalQueryParser
import org.slf4j.LoggerFactory
import query.websocket.QueryBuilder
import query.websocket.QueryExecutioner
import utils.CineastException
import java.net.URI

/**
 * Initiate queries and retrieve all completed queries (where the right number of responses have been sent) to the callee.
 */

class QueryProcessor(uri: URI) {
    private val temporalQueryParser: TemporalQueryParser = TemporalQueryParser()
    private val queryBuilder: QueryBuilder = QueryBuilder()
    private val queryExecutioner: QueryExecutioner = QueryExecutioner(uri)
    private val queryResultMap: HashMap<String, QueryStorage> = HashMap()
    private val logger = LoggerFactory.getLogger(javaClass)
    private val returnedResults: HashMap<String, QueryStorage> = HashMap()

    fun initiateQueries(s: List<SpecificationTask>) {
        for (task in s) {
            val query =
                queryBuilder.buildTemporalQuery(task.queries, task.config, task.maxLength, task.timeDistances)
            logger.info(temporalQueryParser.fromModelToJson(query))
            queryResultMap[query.config.queryId] = QueryStorage(query)
            queryExecutioner.send(
                temporalQueryParser.fromModelToJson(
                    query
                )
            )
        }
    }

    fun retrieveCompleteQueries(): HashMap<String, QueryStorage> {
        val results = queryExecutioner.retrieveMessages()
        val completeQueriesMap = HashMap<String, QueryStorage>()
        logger.debug(results.toString())

        if (results.isNotEmpty()) {
            for (result in results) {
                logger.debug("result: ${result.queryId}")
                queryResultMap[result.queryId]?.addResponse(result)
            }

            queryResultMap.forEach { (k, storage) ->
                if (!returnedResults.containsKey(k)) {
                    try {
                        if (storage.complete()) {
                            logger.debug("Query $k complete.")
                            completeQueriesMap[k] = storage
                            returnedResults[k] = storage
                        }
                    } catch (e: CineastException) {
                        logger.error(e.toString())
                    }
                }
            }
        }
        return completeQueriesMap
    }
}

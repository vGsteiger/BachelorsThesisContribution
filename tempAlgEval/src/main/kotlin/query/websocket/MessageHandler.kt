package query.websocket

import json.CineastConstants.OBJECTQUERYRESULT
import json.CineastConstants.PING
import json.CineastConstants.QUERYEND
import json.CineastConstants.QUERYERROR
import json.CineastConstants.QUERYMETADATAO
import json.CineastConstants.QUERYMETADATAS
import json.CineastConstants.QUERYSTART
import json.CineastConstants.SEGMENTQUERYRESULT
import json.CineastConstants.SIMILARITYQUERYRESULT
import json.Model
import json.QueryResult
import json.parsers.MetadataQueryResultOParser
import json.parsers.MetadataQueryResultSParser
import json.parsers.ObjectQueryResultParser
import json.parsers.PingResponseParser
import json.parsers.QueryEndParser
import json.parsers.QueryErrorParser
import json.parsers.QueryStartParser
import json.parsers.SegmentQueryResultParser
import json.parsers.SimilarityQueryResultParser
import org.slf4j.LoggerFactory
import kotlin.properties.Delegates

/**
 * Class to handle the message responses from Cineast upon a query. Other classes observe this class to retrieve the query results.
 */
class MessageHandler {
    private val similarityQueryResultParser: SimilarityQueryResultParser =
        SimilarityQueryResultParser()
    private val queryStartParser: QueryStartParser =
        QueryStartParser()
    private val queryEndParser: QueryEndParser = QueryEndParser()
    private val objectQueryResultParser: ObjectQueryResultParser =
        ObjectQueryResultParser()
    private val segmentQueryResultParser: SegmentQueryResultParser =
        SegmentQueryResultParser()
    private val pingResponseParser: PingResponseParser =
        PingResponseParser()
    private val queryErrorParser: QueryErrorParser =
        QueryErrorParser()
    private val metadataQueryResultSParser: MetadataQueryResultSParser =
        MetadataQueryResultSParser()
    private val metadataQueryResultOParser: MetadataQueryResultOParser =
        MetadataQueryResultOParser()
    private val logger = LoggerFactory.getLogger(javaClass)

    val messageObservers = mutableListOf<(QueryResult?) -> Unit>()
    private var newestMessage: QueryResult? by Delegates.observable(null) { _, _, newValue ->
        messageObservers.forEach { it(newValue) }
    }

    fun processMessage(message: String?) {
        var m: Model? = null
        if (message == null) {
            return
        } else {
            when {
                message.contains(SIMILARITYQUERYRESULT) ->
                    m =
                        similarityQueryResultParser.fromJsonToModel(message)
                message.contains(OBJECTQUERYRESULT) ->
                    m =
                        objectQueryResultParser.fromJsonToModel(message)
                message.contains(SEGMENTQUERYRESULT) ->
                    m =
                        segmentQueryResultParser.fromJsonToModel(message)
                message.contains(QUERYSTART) ->
                    m =
                        queryStartParser.fromJsonToModel(message)
                message.contains(QUERYEND) ->
                    m =
                        queryEndParser.fromJsonToModel(message)
                message.contains(PING) ->
                    m =
                        pingResponseParser.fromJsonToModel(message)
                message.contains(QUERYERROR) ->
                    m =
                        queryErrorParser.fromJsonToModel(message)
                message.contains(QUERYMETADATAS) ->
                    m =
                        metadataQueryResultSParser.fromJsonToModel(message)
                message.contains(QUERYMETADATAO) ->
                    m =
                        metadataQueryResultOParser.fromJsonToModel(message)
                else -> {
                    logger.error("Unknown message: $message")
                }
            }
        }
        newestMessage = m as QueryResult?
    }
}

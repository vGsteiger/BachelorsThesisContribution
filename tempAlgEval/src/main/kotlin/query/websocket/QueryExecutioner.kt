package query.websocket

import json.QueryResult
import org.slf4j.LoggerFactory
import java.net.URI
import java.util.Collections.synchronizedList

/**
 * Execute the queries and retrieve the results from observing the message handler of the websocket client.
 */

class QueryExecutioner(uri: URI) {
    private val wsClient: WSClient = WSClient(uri)
    private val messageList: MutableList<QueryResult?> =
        synchronizedList(mutableListOf())
    private val logger = LoggerFactory.getLogger(javaClass)

    init {
        wsClient.connect()
        wsClient.messageHandler.messageObservers.add { newestMessage ->
            messageList.add(newestMessage)
        }
    }

    fun send(message: String) {
        wsClient.send(message)
    }

    fun retrieveMessages(): List<QueryResult> {
        var tmp = listOf<QueryResult>()
        try {
            tmp = messageList.filterNotNull()
        } catch (e: ConcurrentModificationException) {
            logger.error(e.toString())
        }
        messageList.clear()
        return tmp
    }
}

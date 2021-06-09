package query.websocket

import org.java_websocket.client.WebSocketClient
import org.java_websocket.handshake.ServerHandshake
import org.slf4j.LoggerFactory
import java.net.URI

/**
 * Handles the WebSocket communication with Cineast. Sends retrieved results to the message handler for handling.
 */
class WSClient(serverURI: URI?) : WebSocketClient(serverURI) {
    var messageHandler: MessageHandler = MessageHandler()
    private val logger = LoggerFactory.getLogger(javaClass)

    init {
        this.messageHandler = MessageHandler()
    }

    override fun onOpen(handshakedata: ServerHandshake?) {
        logger.info("Server Handshake proceeding")
    }

    override fun onMessage(message: String?) {
        this.messageHandler.processMessage(message)
    }

    override fun onClose(
        code: Int,
        reason: String?,
        remote: Boolean
    ) {
        println(
            "Connection closed by " + (if (remote) "remote peer" else "us") + " Code: " + code + " Reason: " + reason
        )
    }

    override fun onError(ex: Exception?) {
        ex?.printStackTrace()
    }
}

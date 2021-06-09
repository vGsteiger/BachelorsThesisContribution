package json

/**
 * Object representing the message types of Cineast.
 */

object CineastConstants {
    const val SIMILARITYQUERYRESULT = "QR_SIMILARITY"
    const val OBJECTQUERYRESULT = "QR_OBJECT"
    const val SEGMENTQUERYRESULT = "QR_SEGMENT"
    const val QUERYSTART = "QR_START"
    const val QUERYEND = "QR_END"
    const val PING = "PING"
    const val QUERYERROR = "QR_ERROR"
    const val QUERYMETADATAS = "QR_METADATA_S"
    const val QUERYMETADATAO = "QR_METADATA_O"
    const val TEMPORALQUERY = "Q_TEMPORAL"
}

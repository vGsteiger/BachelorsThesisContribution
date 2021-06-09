package json

import json.CineastConstants.OBJECTQUERYRESULT
import json.CineastConstants.QUERYEND
import json.CineastConstants.QUERYERROR
import json.CineastConstants.QUERYMETADATAO
import json.CineastConstants.QUERYMETADATAS
import json.CineastConstants.QUERYSTART
import json.CineastConstants.SEGMENTQUERYRESULT
import json.CineastConstants.SIMILARITYQUERYRESULT
import json.CineastConstants.TEMPORALQUERY
import org.slf4j.LoggerFactory
import utils.CineastException

/**
 * This file is a collection of data classes used thruought the application. Most reflect a Cineast API message definition for the communication with the running Cineast instance.
 */

interface Model

abstract class QueryResult : Model {
    abstract val queryId: String
    abstract val messageType: String

    override fun toString(): String {
        return messageType
    }
}

data class Specifications(val tasks: List<SpecificationTask>) : Model

data class SpecificationTask(
    val taskDescription: String,
    val taskType: TaskType,
    val correctResult: Result,
    val queries: List<Query>,
    val config: QueryConfig,
    val timeDistances: List<Int>
) : Model

data class Result(
    val V3C1ObjectId: String,
    val startAbs: Float,
    val endAbs: Float
) : Model {
    fun otherIsWithin(r: Result): Boolean {
        return r.V3C1ObjectId == this.V3C1ObjectId && this.startAbs <= r.startAbs && r.endAbs <= this.endAbs
    }

    fun isSimilar(r: Result, v: Float): Boolean {
        return r.V3C1ObjectId == this.V3C1ObjectId &&
                (this.startAbs - v <= r.startAbs || r.startAbs <= this.startAbs + v) &&
                (this.endAbs - v <= r.endAbs || r.endAbs <= this.endAbs + v)
    }
}

data class Query(
    val containers: List<QueryContainer>
)

data class QueryContainer(
    val terms: List<Term>
)

data class Term(
    val category: VBSCategories,
    val type: List<VBSTypes>,
    val data: String // base64 string!
)

data class TemporalQuery(
    val queries: List<StageComponent>,
    val config: QueryConfig = QueryConfig(),
    val messageType: String = TEMPORALQUERY
) : Model

data class StageComponent(
    val stages: List<QueryComponent>
) : Model

data class QueryComponent(
    val terms: List<QueryTerm>
) : Model

data class QueryParameters(
    val taskType: TaskType,
    val taskId: String
) : Model

data class OrderedResults(
    val algorithmId: String,
    val results: LinkedHashMap<Result, Float>,
    val scoringTime: Long,
    val scoringMemory: Long
) : Model

data class ResultScoreTuple(
    val results: LinkedHashMap<Result, Float>
)

data class QuantitativeResults(
    val average: Float,
    val median: Float,
    val best: Float,
    val worst: Float
)

data class QueryConfig(
    val queryId: String = "",
    val hints: List<Hints> = listOf()
) : Model

data class QueryTerm(
    val type: QueryTermType,
    val tags: List<Tag> = listOf(),
    val sliderSetting: Float = 0f,
    val categories: List<Categories>,
    val data: String,
) : Model

data class Tag(
    val id: String,
    val name: String,
    val description: String
)

data class PingResponse(val status: String, val messageType: String) :
    Model

data class SimilarityQueryResult(
    val content: List<SegmentWeight>,
    val contentType: String,
    override val queryId: String,
    val category: String,
    val containerId: Int,
    override val messageType: String = SIMILARITYQUERYRESULT
) : QueryResult() {
    override fun toString(): String {
        return super.toString()
    }
}

data class SegmentWeight(
    val key: String,
    val value: Float
) : Model

data class QueryStart(
    override val queryId: String,
    override val messageType: String = QUERYSTART
) : QueryResult() {
    override fun toString(): String {
        return super.toString()
    }
}

data class ObjectQueryResult(
    val content: List<MultimediaObjectDescriptor>,
    val contentType: String,
    override val queryId: String,
    override val messageType: String = OBJECTQUERYRESULT
) : QueryResult() {
    override fun toString(): String {
        return super.toString()
    }
}

data class MultimediaObjectDescriptor(
    val objectId: String,
    val name: String,
    val path: String,
    val mediatype: MediaType,
    val contentURL: String
) : Model

data class SegmentMap(
    val segments: HashMap<String, SegmentDescriptor>
)

data class SegmentQueryResult(
    val content: List<SegmentDescriptor>,
    val contentType: String,
    override val queryId: String,
    override val messageType: String = SEGMENTQUERYRESULT
) : QueryResult() {
    override fun toString(): String {
        return super.toString()
    }
}

data class ScoreSegmentTuple(
    val score: Float,
    val segment: String,
)

data class SegmentDescriptor(
    val segmentId: String,
    val objectId: String,
    val start: Int,
    val end: Int,
    val startabs: Float,
    val endabs: Float,
    val sequenceNumber: Int,
    val count: Int
) : Model

data class QueryEnd(
    override val queryId: String,
    override val messageType: String = QUERYEND
) : QueryResult() {
    override fun toString(): String {
        return super.toString()
    }
}

data class ErrorResult(
    override var queryId: String,
    val errorMessage: String,
    override val messageType: String = QUERYERROR
) : QueryResult() {
    override fun toString(): String {
        return super.toString()
    }
}

data class MetadataQueryResultS(
    val content: List<MediaSegmentMetadataDescriptor>,
    val contentType: String,
    override val queryId: String,
    override val messageType: String = QUERYMETADATAS
) : QueryResult() {
    override fun toString(): String {
        return super.toString()
    }
}

data class MetadataQueryResultO(
    val content: List<MediaObjectMetadataDescriptor>,
    val contentType: String,
    override val queryId: String,
    override val messageType: String = QUERYMETADATAO
) : QueryResult() {
    override fun toString(): String {
        return super.toString()
    }
}

data class MediaObjectMetadataDescriptor(
    val objectId: String,
    val domain: String,
    val key: String,
    val value: String
) : Model

data class MediaSegmentMetadataDescriptor(
    val segmendId: String,
    val domain: String,
    val key: String,
    val value: String
) : Model

data class EvaluationResultContainer(
    val taskId: String = "",
    val taskType: TaskType = TaskType.KIST,
    val algorithmId: String = "",
    val scoringTime: Long = 0L,
    val numberOfTemporalQueries: Int = 0,
    val searchedItemPosition: Int = 0,
    val searchedObjectPositionSum: Int = 0,
    val objectNr: Int = 0,
    val firstOccurrence: Int = 0,
    val totalItems: Int = 0,
    val searchedItemScore: Float = 0.0f,
    val vbsScore: Float = 0.0f,
    val avgScore: Float = 0.0f,
    val medianScore: Float = 0.0f,
    val bestScore: Float = 0.0f,
    val worstScore: Float = 0.0f,
    val numberCineastResults: Int = -1
)

data class StringDoublePair(
    val key: String,
    val value: Double
)

data class PrecisionRecall(
    val precisionScores: ArrayList<Float>,
    val recallScores: ArrayList<Float>
)

class QueryStorage(
    val temporalQuery: TemporalQuery
) {
    val responses: MutableList<QueryResult> = mutableListOf()
    private var hasError: Boolean = false
    private lateinit var error: ErrorResult
    private var numberOfResponsePackets: Int = 0
    private var hasStart = false
    private var hasEnd = false
    private val logger = LoggerFactory.getLogger(javaClass)

    init {
        for (query in temporalQuery.queries) {
            if (query.stages.size == 1) {
                for (stage in query.stages) {
                    for (term in stage.terms) {
                        numberOfResponsePackets += 3
                    }
                }
            } else {
                for (stage in query.stages) {
                    for (term in stage.terms) {
                        numberOfResponsePackets += 1
                    }
                }
                numberOfResponsePackets += 2
            }
        }
        logger.debug(numberOfResponsePackets.toString())
    }

    override fun toString(): String {
        return "Responses=$responses)"
    }

    fun addResponse(queryResult: QueryResult) {
        logger.debug("Added response: $queryResult")
        when (queryResult.messageType) {
            QUERYERROR -> {
                hasError = true
                error = queryResult as ErrorResult
            }
            QUERYSTART -> {
                hasStart = true
            }
            QUERYEND -> {
                hasEnd = true
            }
            QUERYMETADATAS -> return
            QUERYMETADATAO -> return
            else -> {
                responses.add(queryResult)
            }
        }
    }

    @Throws(CineastException::class)
    fun complete(): Boolean {
        if (hasError) {
            throw CineastException(error.errorMessage)
        }
        return (responses.size == numberOfResponsePackets)
    }
}

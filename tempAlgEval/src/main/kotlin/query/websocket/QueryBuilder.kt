package query.websocket

import com.google.gson.Gson
import com.google.gson.JsonParseException
import com.google.gson.JsonSyntaxException
import com.google.gson.reflect.TypeToken
import json.Categories
import json.Query
import json.QueryComponent
import json.QueryConfig
import json.QueryTerm
import json.QueryTermType
import json.StageComponent
import json.Tag
import json.TemporalQuery
import json.VBSTypes
import org.slf4j.LoggerFactory
import java.util.*
import kotlin.collections.ArrayList

/**
 * Converts the specification file to Cineast ready temporal query messages.
 */

class QueryBuilder {
    private val logger = LoggerFactory.getLogger(javaClass)
    private val gson: Gson = Gson()

    fun buildTemporalQuery(queries: List<Query>, config: QueryConfig, maxLength: Float, timeDistances: List<Int>): TemporalQuery {

        val temporalQueries: MutableList<StageComponent> = mutableListOf()

        for (q in queries) {
            val stages: MutableList<QueryComponent> = mutableListOf()

            for (container in q.containers) {
                val terms: MutableList<QueryTerm> = mutableListOf()
                for (term in container.terms) {

                    var cineastType: QueryTermType = QueryTermType.UNINITIATED
                    val cineastCategories: MutableList<Categories> = ArrayList()
                    for (type in term.type) {
                        when (type) {
                            VBSTypes.ASR -> {
                                cineastCategories.add(Categories.asr)
                            }
                            VBSTypes.concept -> {
                                cineastCategories.add(Categories.tags)
                            }
                            VBSTypes.OCR -> {
                                cineastCategories.add(Categories.ocr)
                            }
                            VBSTypes.semanticSegmentation -> {
                                cineastCategories.add(Categories.semantic)
                            }
                            VBSTypes.caption -> {
                                cineastCategories.add(Categories.scenecaption)
                            }
                            VBSTypes.localizedObject -> {
                                cineastCategories.add(Categories.semantic)
                            }
                            VBSTypes.globalFeatures -> {
                                cineastCategories.add(Categories.globalcolor)
                            }
                            VBSTypes.localFeatures -> {
                                cineastCategories.add(Categories.localcolor)
                            }
                            VBSTypes.edge -> {
                                cineastCategories.add(Categories.edge)
                            }
                            VBSTypes.visualtextcoembedding -> {
                                cineastCategories.add(Categories.visualtextcoembedding)
                            }
                            VBSTypes.segmentTags -> {
                                cineastCategories.add(Categories.tags)
                            }
                            else -> continue
                        }
                    }
                    for (category in cineastCategories) {
                        when (category) {
                            Categories.semantic -> {
                                if (cineastCategories.size == 1) {
                                    cineastType = QueryTermType.SEMANTIC
                                } else throw JsonParseException("Invalid combination of categories")
                            }
                            Categories.globalcolor -> {
                                if (cineastType == QueryTermType.UNINITIATED || cineastType == QueryTermType.IMAGE) {
                                    cineastType = QueryTermType.IMAGE
                                } else throw JsonParseException("Invalid combination of categories")
                            }
                            Categories.localcolor -> if (cineastType == QueryTermType.UNINITIATED || cineastType == QueryTermType.IMAGE) {
                                cineastType = QueryTermType.IMAGE
                            } else throw JsonParseException("Invalid combination of categories")
                            Categories.edge -> if (cineastType == QueryTermType.UNINITIATED || cineastType == QueryTermType.IMAGE) {
                                cineastType = QueryTermType.IMAGE
                            } else throw JsonParseException("Invalid combination of categories")
                            Categories.tags -> {
                                if (cineastCategories.size == 1) {
                                    cineastType = QueryTermType.TAG
                                } else throw JsonParseException("Invalid combination of categories")
                            }
                            Categories.ocr -> if (cineastType == QueryTermType.UNINITIATED || cineastType == QueryTermType.TEXT) {
                                cineastType = QueryTermType.TEXT
                            } else throw JsonParseException("Invalid combination of categories")
                            Categories.asr -> if (cineastType == QueryTermType.UNINITIATED || cineastType == QueryTermType.TEXT) {
                                cineastType = QueryTermType.TEXT
                            } else throw JsonParseException("Invalid combination of categories")
                            Categories.visualtextcoembedding -> if (cineastType == QueryTermType.UNINITIATED || cineastType == QueryTermType.TEXT) {
                                cineastType = QueryTermType.TEXT
                            } else throw JsonParseException("Invalid combination of categories")
                            Categories.scenecaption -> if (cineastType == QueryTermType.UNINITIATED || cineastType == QueryTermType.TEXT) {
                                cineastType = QueryTermType.TEXT
                            } else throw JsonParseException("Invalid combination of categories")
                            else -> {
                                logger.info("Unknown category occurred $category")
                                continue
                            }
                        }
                    }
                    var tags: List<Tag> = listOf()
                    if (cineastType == QueryTermType.TAG) {
                        val tmpString = term.data.split(",")[1]
                        val decodedBytes = Base64.getDecoder().decode(tmpString)
                        val decodedData = String(decodedBytes)
                        try {
                            val listTagType = object : TypeToken<List<Tag>>() {}.type
                            tags = gson.fromJson(decodedData, listTagType)
                        } catch (e: JsonSyntaxException) {
                            logger.error(e.toString())
                        }
                    }
                    val queryTerm = QueryTerm(
                        cineastType,
                        tags,
                        1f,
                        cineastCategories.toList(),
                        term.data
                    )
                    terms.add(queryTerm)
                }
                val term = QueryComponent(terms)
                stages.add(term)
            }
            val stageComponent = StageComponent(stages)
            temporalQueries.add(stageComponent)
        }

        return TemporalQuery(temporalQueries, config, timeDistances, maxLength)
    }
}

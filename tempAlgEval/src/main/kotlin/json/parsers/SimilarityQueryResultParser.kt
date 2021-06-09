package json.parsers

import json.Model
import json.SimilarityQueryResult
import java.io.File

class SimilarityQueryResultParser : Parser() {
    override fun fromJsonToModel(s: String): Model {
        return gson.fromJson(s, SimilarityQueryResult::class.java)
    }

    override fun fromFileToModel(file: String): Model {
        val f = File(file).readText()
        return gson.fromJson(f, SimilarityQueryResult::class.java)
    }
}

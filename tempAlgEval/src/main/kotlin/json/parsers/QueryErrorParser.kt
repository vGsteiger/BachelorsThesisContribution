package json.parsers

import json.ErrorResult
import json.Model
import java.io.File

class QueryErrorParser : Parser() {

    override fun fromJsonToModel(s: String): Model {
        return gson.fromJson(s, ErrorResult::class.java)
    }

    override fun fromFileToModel(file: String): Model {
        val f = File(file).readText()
        return gson.fromJson(f, ErrorResult::class.java)
    }
}

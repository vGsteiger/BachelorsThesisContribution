package json.parsers

import json.Model
import json.QueryStart
import java.io.File

class QueryStartParser : Parser() {
    override fun fromJsonToModel(s: String): Model {
        return gson.fromJson(s, QueryStart::class.java)
    }

    override fun fromFileToModel(file: String): Model {
        val f = File(file).readText()
        return gson.fromJson(f, QueryStart::class.java)
    }
}

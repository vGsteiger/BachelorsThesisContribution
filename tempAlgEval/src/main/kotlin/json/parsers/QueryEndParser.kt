package json.parsers

import json.Model
import json.QueryEnd
import java.io.File

class QueryEndParser : Parser() {
    override fun fromJsonToModel(s: String): Model {
        return gson.fromJson(s, QueryEnd::class.java)
    }

    override fun fromFileToModel(file: String): Model {
        val f = File(file).readText()
        return gson.fromJson(f, QueryEnd::class.java)
    }
}

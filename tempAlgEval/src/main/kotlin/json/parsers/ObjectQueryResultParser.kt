package json.parsers

import json.Model
import json.ObjectQueryResult
import java.io.File

class ObjectQueryResultParser : Parser() {
    override fun fromJsonToModel(s: String): Model {
        return gson.fromJson(s, ObjectQueryResult::class.java)
    }

    override fun fromFileToModel(file: String): Model {
        val f = File(file).readText()
        return gson.fromJson(f, ObjectQueryResult::class.java)
    }
}

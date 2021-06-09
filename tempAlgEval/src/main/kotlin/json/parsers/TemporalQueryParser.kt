package json.parsers

import json.Model
import json.TemporalQuery
import java.io.File

class TemporalQueryParser : Parser() {

    override fun fromJsonToModel(s: String): Model {
        return gson.fromJson(s, TemporalQuery::class.java)
    }

    override fun fromFileToModel(file: String): Model {
        val f = File(file).readText()
        return gson.fromJson(f, TemporalQuery::class.java)
    }
}

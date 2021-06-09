package json.parsers

import json.Model
import json.SegmentQueryResult
import java.io.File

class SegmentQueryResultParser : Parser() {
    override fun fromJsonToModel(s: String): Model {
        return gson.fromJson(s, SegmentQueryResult::class.java)
    }

    override fun fromFileToModel(file: String): Model {
        val f = File(file).readText()
        return gson.fromJson(f, SegmentQueryResult::class.java)
    }
}

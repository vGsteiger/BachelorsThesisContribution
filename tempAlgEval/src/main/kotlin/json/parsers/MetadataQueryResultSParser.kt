package json.parsers

import json.MetadataQueryResultS
import json.Model
import java.io.File

class MetadataQueryResultSParser : Parser() {

    override fun fromJsonToModel(s: String): Model {
        return gson.fromJson(s, MetadataQueryResultS::class.java)
    }

    override fun fromFileToModel(file: String): Model {
        val f = File(file).readText()
        return gson.fromJson(f, MetadataQueryResultS::class.java)
    }
}

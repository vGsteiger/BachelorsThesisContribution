package json.parsers

import json.MetadataQueryResultO
import json.Model
import java.io.File

class MetadataQueryResultOParser : Parser() {

    override fun fromJsonToModel(s: String): Model {
        return gson.fromJson(s, MetadataQueryResultO::class.java)
    }

    override fun fromFileToModel(file: String): Model {
        val f = File(file).readText()
        return gson.fromJson(f, MetadataQueryResultO::class.java)
    }
}

package json.parsers

import json.Model
import json.Specifications
import java.io.File

class SpecificationsParser : Parser() {

    override fun fromJsonToModel(s: String): Model {
        return gson.fromJson(s, Specifications::class.java)
    }

    override fun fromFileToModel(file: String): Model {
        val f = File(file).readText()
        return gson.fromJson(f, Specifications::class.java)
    }
}

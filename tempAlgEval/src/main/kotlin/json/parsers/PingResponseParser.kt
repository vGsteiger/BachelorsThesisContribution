package json.parsers

import json.Model
import json.PingResponse
import java.io.File

class PingResponseParser : Parser() {

    override fun fromJsonToModel(s: String): Model {
        return gson.fromJson(s, PingResponse::class.java)
    }

    override fun fromFileToModel(file: String): Model {
        val f = File(file).readText()
        return gson.fromJson(f, PingResponse::class.java)
    }
}

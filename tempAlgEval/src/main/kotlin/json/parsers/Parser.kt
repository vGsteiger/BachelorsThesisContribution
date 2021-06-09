package json.parsers

import com.google.gson.Gson
import json.Model
import java.io.File

abstract class Parser {
    protected val gson: Gson = Gson()

    fun fromModelToJson(m: Model): String {
        return gson.toJson(m)
    }

    abstract fun fromJsonToModel(s: String): Model

    fun fromModelToFile(m: Model, file: String): String {
        val json = gson.toJson(m)
        File(file).writeText(json)
        return file
    }

    abstract fun fromFileToModel(file: String): Model
}

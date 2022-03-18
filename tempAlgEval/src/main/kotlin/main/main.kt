@file:JvmName("Main")

package main

import com.google.gson.Gson
import json.Specifications
import json.parsers.SpecificationsParser
import java.io.File
import java.net.URI

val gson: Gson = Gson()

/**
 * Main function to start an evaluation run
 */
fun main(args: Array<String>) {

    val uri = URI("ws://localhost:4567/api/v1/websocket") // ws://10.34.58.178:4567/api/v1/websocket

    /*Parameter format:
        1. code (queries specified in code) or json (queries specified in json format)
        2. source of queries (queries specified in json format)
        3. path for evaluation results (queries specified in json format)

     */
    if (args[0].equals("code")) {
        val specsBuilder = SpecsBuilder()
        val specParser = SpecificationsParser()

        val specifications = specsBuilder.buildSpecs()

        specParser.fromModelToFile(
                specifications,
                "/Users/viktorgsteiger/localDocs/University/BA-VG-fs21/tempAlgEval/src/main/assets/specifications.json"
        )

        val app = EvalApp(
                uri,
                specifications,
                "/Users/viktorgsteiger/localDocs/University/BA-VG-fs21/tempAlgEval/src/main/assets/qualityEvaluation/query3/visualCoEmbedding.csv"
        )
        app.evaluate(10)

    } else if (args[0].equals("json")) {
        if (args.size != 3) {
            println("Command line parameters are not in correct format for starting evaluation run with queries specified in JSON format")
            println("Correct format: json <path_to_query_specifications> <path_to_store_evaluation_results>")
            return
        }
        val jsonString: String = File(args[1]).readText(Charsets.UTF_8)
        val specifications = gson.fromJson(jsonString, Specifications::class.java)

        val app = EvalApp(
                uri,
                specifications,
                args[2]
        )
        app.evaluate(10)
    }
    return
}

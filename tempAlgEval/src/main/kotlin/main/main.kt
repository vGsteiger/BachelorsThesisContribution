@file:JvmName("Main")

package main

import json.parsers.SpecificationsParser
import java.net.URI

/**
 * Main function to start an evaluation run
 */
fun main() {

    val uri = URI("ws://localhost:4567/api/v1/websocket") // ws://10.34.58.178:4567/api/v1/websocket

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
    return
}

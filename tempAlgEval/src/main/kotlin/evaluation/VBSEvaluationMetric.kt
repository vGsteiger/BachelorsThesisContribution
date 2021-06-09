package evaluation

import json.EvaluationMetrics
import json.OrderedResults
import json.Result
import kotlin.math.ceil
import kotlin.math.max

/**
 * Abstract class of the VBS evaluation metric that requires the inheriting class to implement their own time and recall penalty
 */
abstract class VBSEvaluationMetric {
    abstract val evaluationMetricId: EvaluationMetrics
    abstract val sc: Float

    fun score(
        correctResult: Result,
        orderedResults: OrderedResults
    ): Float {
        var ws = 0
        var cRes = false
        for (oResult in orderedResults.results.asIterable()) {
            if (compareResults(oResult.key, correctResult)) {
                cRes = true
                break
            }
            ws++
        }
        if (!cRes) {
            return 0.0f
        }
        return ceil(
            max(
                0.0f,
                sc + (100f - sc) * timePenalty(
                    orderedResults.scoringTime
                ) - recallPenalty(ws)
            )
        )
    }

    private fun compareResults(
        givenResult: Result,
        correctResult: Result
    ): Boolean {
        return (givenResult.startAbs >= correctResult.startAbs && givenResult.endAbs <= correctResult.endAbs)
    }

    abstract fun recallPenalty(ws: Int): Float

    abstract fun timePenalty(usedTime: Long): Float
}

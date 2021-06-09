package evaluation

import json.EvaluationMetrics
/**
 * Specific implementation with the functions used at VBS 2019
 */
class VBS2019(override val sc: Float, private val p: Float) :
    VBSEvaluationMetric() {
    override val evaluationMetricId: EvaluationMetrics
        get() = EvaluationMetrics.VBS2019

    override fun recallPenalty(ws: Int): Float {
        return ws.toFloat() * p
    }

    override fun timePenalty(usedTime: Long): Float {
        return ((5000000000f - usedTime.toFloat()) / 5000000000f)
    }
}

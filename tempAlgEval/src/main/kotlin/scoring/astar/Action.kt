package scoring.astar

import kotlin.math.abs

class Action(private val timeForward: Float) {

    fun cost(timeToNext: Float): Float {
        return if (abs(timeForward) <= timeToNext) {
            timeToNext - timeForward + 1f
        } else {
            150f + abs(timeToNext - timeForward + 1f)
        }
    }

    override fun toString(): String {
        return "Action(timeForward=$timeForward)"
    }
}

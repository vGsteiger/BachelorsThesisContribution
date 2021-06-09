package scoring.astar

data class ActionStatePair(val action: Action, val state: State) {
    override fun toString(): String {
        return "ActionStatePair(action=$action, state=$state)"
    }
}
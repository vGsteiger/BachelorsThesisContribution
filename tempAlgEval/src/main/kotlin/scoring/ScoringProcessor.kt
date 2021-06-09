package scoring

/**
 * Storage class to safe the instances of the scoring algorithms
 */
class ScoringProcessor {
    private var scoringAlgorithms: ArrayList<ScoringAlgorithm> = ArrayList()

    fun addScoringAlgorithm(scoringAlgorithm: ScoringAlgorithm) {
        scoringAlgorithms.add(scoringAlgorithm)
    }
}

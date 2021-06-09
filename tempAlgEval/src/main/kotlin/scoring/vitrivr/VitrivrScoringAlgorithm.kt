package scoring.vitrivr

import json.Categories
import json.CineastConstants
import json.ObjectQueryResult
import json.QueryStorage
import json.Result
import json.ResultScoreTuple
import json.SegmentQueryResult
import json.SimilarityQueryResult
import json.StringDoublePair
import org.slf4j.LoggerFactory
import scoring.ScoringAlgorithm
import kotlin.math.max

/**
 * Implementation of the vitrivr scoring algorithm as described in the thesis.
 */
class VitrivrScoringAlgorithm : ScoringAlgorithm() {
    override val algorithmId: String = "VITRIVR"
    private val tmpObjectStorage = mutableListOf<ObjectQueryResult>()
    private val tmpSimilarityStorage =
        mutableListOf<SimilarityQueryResult>()
    private val tmpSegmentStorage =
        mutableListOf<SegmentQueryResult>()
    private val mediaObjectScoreContainers =
        HashMap<String, MediaObjectScoreContainer>()
    private var queryContainerCount: Int = 0
    private val _temporalDistances = mutableListOf<Int>()
    private val _bestPathPerCombination =
        HashMap<String, SegmentContainerIdentifier>()
    private val _paths = HashMap<String, ScoredPath>()
    private val logger = LoggerFactory.getLogger(javaClass)

    override fun scoreInternal(
        queryStorage: QueryStorage,
        timeDistances: ArrayList<Int>
    ): ResultScoreTuple {
        _temporalDistances.addAll(timeDistances)
        queryStorage.responses.forEach { response ->
            run {
                when (response.messageType) {
                    CineastConstants.OBJECTQUERYRESULT -> return@forEach
                    CineastConstants.SEGMENTQUERYRESULT -> {
                        tmpSegmentStorage.add(
                            response as SegmentQueryResult
                        )
                    }
                    CineastConstants.SIMILARITYQUERYRESULT -> run {
                        response as SimilarityQueryResult
                        queryContainerCount = max(
                            (response).containerId,
                            queryContainerCount
                        )
                        tmpSimilarityStorage.add(
                            response
                        )
                    }
                    CineastConstants.QUERYEND -> return@forEach
                    CineastConstants.QUERYSTART -> return@forEach
                    else -> logger.error("Unknown message: ${response.messageType}")
                }
            }
        }

        queryContainerCount += 1

        tmpSegmentStorage.forEach { o ->
            o.content.forEach {
                if (!mediaObjectScoreContainers.containsKey(it.objectId)) {
                    mediaObjectScoreContainers[it.objectId] = MediaObjectScoreContainer()
                }
            }
        }

        tmpSegmentStorage.forEach { o ->
            o.content.forEach {
                mediaObjectScoreContainers[it.objectId]?.addMediaSegment(
                    it
                )
            }
        }

        tmpSimilarityStorage.forEach { o ->
            o.content.forEach {
                val tmpObjectId = it.key.substring(0, 7)
                mediaObjectScoreContainers[tmpObjectId]?.addSimilarity(
                    Categories.valueOf(o.category),
                    StringDoublePair(it.key, it.value.toDouble()),
                    o.containerId
                )
            }
        }

        var tmp = 0
        mediaObjectScoreContainers.forEach { (_, u) ->
            run {
                tmp++
                u.update(this)
            }
        }

        val resultScoreTuple = LinkedHashMap<Result, Float>()

        _paths.forEach { (t, u) ->
            run {
                val tmpBestPathCombination = _bestPathPerCombination[t]
                if (tmpBestPathCombination != null) {
                    val tmpObjectId = tmpBestPathCombination.segmentId.substring(0, 7)
                    val segDesc =
                        mediaObjectScoreContainers[
                                tmpBestPathCombination.segmentId.substring(
                                    0,
                                    7
                                )
                        ]?.getSegmentDescriptor(tmpBestPathCombination.segmentId)
                    var topSegment = -1
                    u.path.pathMap.forEach { (t, _) ->
                        if (t > topSegment) {
                            topSegment = t
                        }
                    }

                    val tmpRes = segDesc?.let {
                        u.path.pathMap[topSegment]?.segmentDescriptor?.let { it1 ->
                            Result(
                                tmpObjectId,
                                it.startabs,
                                it1.endabs
                            )
                        }
                    }
                    if (tmpRes != null) {
                        val f = temporalScore(u.path).toFloat()
                        if (resultScoreTuple.containsKey(tmpRes)) {
                            if (resultScoreTuple[tmpRes]!! < f) {
                                resultScoreTuple[tmpRes] = f
                            }
                        } else {
                            resultScoreTuple[tmpRes] = f
                        }
                    }
                }
            }
        }

        return ResultScoreTuple(resultScoreTuple)
    }

    fun scoreForObject(mediaObjectScoreContainer: MediaObjectScoreContainer): Double {
        var paths: HashMap<String, ScoredPath>
        paths = this.computePaths(mediaObjectScoreContainer)
        val maxBy = paths.maxByOrNull { it.value.score }
        return maxBy!!.value.score
    }

    private fun computePaths(objectContainer: MediaObjectScoreContainer): HashMap<String, ScoredPath> {
        val segmentsTemporallyOrdered =
            mutableListOf<MediaSegmentScoreContainer>()
        objectContainer.segments.forEach {
            segmentsTemporallyOrdered.add(
                it
            )
        }
        segmentsTemporallyOrdered.sortBy { it.segmentDescriptor.startabs }

        segmentsTemporallyOrdered.forEachIndexed { index, segment ->
            run {
                segment.scores.forEach { (containerId, _) ->
                    val suggestion = Path(HashMap())
                    suggestion.pathMap[containerId] = segment
                    var tmp = 1
                    if (segmentsTemporallyOrdered.size == 1) {
                        tmp = 0
                    }
                    var recursiveSuggestion: Path
                    recursiveSuggestion = this.temporalPath(
                        segment,
                        segmentsTemporallyOrdered.slice(
                            IntRange(
                                index + tmp,
                                segmentsTemporallyOrdered.size - 1
                            )
                        ).toMutableList(),
                        containerId,
                        suggestion
                    )

                    val recursiveSuggestionScore =
                        recursiveSuggestion.let {
                            this.temporalScore(
                                it
                            )
                        }

                    recursiveSuggestion.pathMap.forEach { (_pathSegmentContainerId, pathSegment) ->
                        run {
                            this.updateCache(
                                pathSegment,
                                _pathSegmentContainerId,
                                recursiveSuggestion,
                                recursiveSuggestionScore
                            )
                        }
                    }
                }
            }
        }

        val paths = HashMap<String, ScoredPath>()
        segmentsTemporallyOrdered.forEach {
            it.scores.forEach { (containerId, _) ->
                val identifier = SegmentContainerIdentifier(
                    it.segmentDescriptor.segmentId,
                    containerId
                )
                if (this._bestPathPerCombination.containsKey(
                        identifier.key()
                    )
                ) {
                    val path: ScoredPath? =
                        this._paths[this._bestPathPerCombination[identifier.key()]?.key()]
                    if (path != null) {
                        paths[path.path.key()] = path
                    }
                }
            }
        }
        return paths
    }

    private fun individualScoreForSegment(segmentScoreContainer: MediaSegmentScoreContainer): Double {
        var score = -1.0
        if (segmentScoreContainer.scores.size != 0) {
            score = this.maxPoolScoreForSegment(segmentScoreContainer)
        }
        return score
    }

    private fun maxPoolScoreForSegment(segmentScoreContainer: MediaSegmentScoreContainer): Double {
        var score = 0.0
        segmentScoreContainer.scores.forEach { (_, categoryMap) ->
            run {
                categoryMap.forEach { (_, categoryScore) ->
                    run {
                        score = max(categoryScore, score)
                    }
                }
            }
        }
        return score
    }

    private fun isLogicalSuccessor(
        predecessor: MediaSegmentScoreContainer,
        predecessorContainerId: Int,
        successor: MediaSegmentScoreContainer,
        containerId: Int
    ): Boolean {
        return if (this._temporalDistances.size > 0 && containerId > 0) {
            this._temporalDistances[containerId - 1] >= (successor.segmentDescriptor.startabs - predecessor.segmentDescriptor.endabs) && predecessorContainerId < containerId
        } else {
            false
        }
    }

    private fun updateCache(
        segment: MediaSegmentScoreContainer,
        containerId: Int,
        path: Path,
        score: Double
    ) {
        val identifier = SegmentContainerIdentifier(
            segment.segmentDescriptor.segmentId,
            containerId
        )
        val start: SegmentContainerIdentifier? = this.start(path)
        if (start != null) {
            if (this._bestPathPerCombination.containsKey(identifier.key())) {
                val pathIdentifier =
                    this._bestPathPerCombination[identifier.key()]
                if (pathIdentifier != null) {
                    if (this._paths[pathIdentifier.key()]?.score!! < score) {
                        this._bestPathPerCombination[identifier.key()] =
                            start
                    }
                }
            } else {
                this._bestPathPerCombination[identifier.key()] = start
            }

            if (this._paths.containsKey(start.key())) {
                if (this._paths[start.key()]?.score!! < score) {
                    val newBestPath = ScoredPath(path, score)
                    this._paths[start.key()] = newBestPath
                }
            } else {
                val newBestPath = ScoredPath(path, score)
                this._paths[start.key()] = newBestPath
            }
        }
    }

    private fun start(path: Path): SegmentContainerIdentifier? {
        var low = Int.MAX_VALUE
        var seg: String? = null
        path.pathMap.forEach { (key, value) ->
            run {
                if (key < low) {
                    low = key
                    seg = value.segmentDescriptor.segmentId
                }
            }
        }
        return seg?.let { SegmentContainerIdentifier(it, low) }
    }

    private fun temporalScore(temporalPath: Path): Double {
        var score = 0.0
        temporalPath.pathMap.forEach { (_, segment) ->
            run {
                score += this.individualScoreForSegment(segment)
            }
        }
        return score / this.queryContainerCount
    }

    private fun temporalPath(
        seeker: MediaSegmentScoreContainer,
        segments: MutableList<MediaSegmentScoreContainer>,
        seekerContainerId: Int,
        pathToAndWithSeeker: Path
    ): Path {
        if (seekerContainerId == this.queryContainerCount - 1) {
            return pathToAndWithSeeker
        }
        var bestScore = this.temporalScore(pathToAndWithSeeker)
        var bestPath = Path(HashMap(pathToAndWithSeeker.pathMap))

        segments.forEachIndexed { candidateSegmentIdx, candidateSegment ->
            run {
                candidateSegment.scores.forEach lit@{ (candidateContainerId, _) ->
                    run {
                        if (!this.isLogicalSuccessor(
                                seeker,
                                seekerContainerId,
                                candidateSegment,
                                candidateContainerId
                            )
                        ) {
                            return@lit
                        }
                        val candidatePath =
                            Path(HashMap(pathToAndWithSeeker.pathMap))
                        candidatePath.pathMap[candidateContainerId] =
                            candidateSegment
                        val candidateScore =
                            this.temporalScore(candidatePath)
                        if (candidateScore >= bestScore) {
                            bestScore = candidateScore
                            bestPath = candidatePath
                        }
                        if (candidateSegmentIdx == segments.size - 1) {
                            return bestPath
                        }
                        val recursivelyFoundPath = this.temporalPath(
                            candidateSegment,
                            segments.slice(
                                IntRange(
                                    candidateSegmentIdx,
                                    segments.size - 1
                                )
                            ).toMutableList(),
                            candidateContainerId,
                            candidatePath
                        )
                        val recursivelyFoundScore =
                            recursivelyFoundPath.let {
                                this.temporalScore(
                                    it
                                )
                            }
                        if (recursivelyFoundScore >= bestScore) {
                            bestScore = recursivelyFoundScore
                            bestPath = recursivelyFoundPath
                        }
                    }
                }
            }
        }
        return bestPath
    }

    override fun clear() {
        tmpObjectStorage.clear()
        tmpSimilarityStorage.clear()
        tmpSegmentStorage.clear()
        mediaObjectScoreContainers.clear()
        queryContainerCount = 0
        _temporalDistances.clear()
        _bestPathPerCombination.clear()
        _paths.clear()
    }
}

package scoring.sequential

import json.SegmentWeight
import java.util.*

class CompareScoredSegments {
    companion object : Comparator<ScoredSegment> {
        override fun compare(o1: ScoredSegment, o2: ScoredSegment): Int {
            return o1.segmentId.compareTo(o2.segmentId)
        }
    }
}

class SortedList(private val underlying: ArrayList<ScoredSegment>) : MutableList<ScoredSegment> by underlying {
    override fun add(element: ScoredSegment): Boolean {
        var index = Collections.binarySearch(underlying, element, CompareScoredSegments)
        if (index < 0) index = index.inv()
        underlying.add(index, element)
        return true
    }

    fun indexOfSegmentweight(element: SegmentWeight): Int {
        var resultIndex = -1
        var tmpIndex = 0
        for (scoredSegment in underlying) {
            if (scoredSegment.segmentId == element.key) {
                resultIndex = tmpIndex
                break
            }
            tmpIndex++
        }
        return resultIndex
    }

    override fun contains(element: ScoredSegment): Boolean {
        return underlying.contains(element)
    }

    fun getListFromElement(element: ScoredSegment): ArrayList<ScoredSegment> {
        val tmpIndex = underlying.indexOf(element)
        val sublist: ArrayList<ScoredSegment>
        if (tmpIndex > 0) {
            sublist = ArrayList(underlying.subList(tmpIndex, underlying.size))
        } else {
            var largerSegmentIndex = 0
            run loop@{
                underlying.forEachIndexed { index, scoredSegment ->
                    if (element.segmentId < scoredSegment.segmentId) {
                        largerSegmentIndex = index
                        return@loop
                    }
                }
            }
            sublist = ArrayList(underlying.subList(largerSegmentIndex, underlying.size))
        }
        return sublist
    }
}

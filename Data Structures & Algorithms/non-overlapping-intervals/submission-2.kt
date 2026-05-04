class Solution {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        if(intervals.size == 1) {
            return 0
        }

        intervals.sortBy {it[0]}
        var first = intervals[0]
        var result = 0
        for(i in 1 until intervals.size) {
            val second = intervals[i]

            if(second[0] >= first[1]) {
                first = second
                continue
            }

            result++
            if(first[1] >= second[1]) {
                first = second
            }
        }
        return result
    }
}

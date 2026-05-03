class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortBy { it[0] }
        val result = mutableListOf<IntArray>()
        var previous: IntArray? = null
        for(interval in intervals) {
            if(previous == null) {
                previous = interval
                continue
            }

            if(interval[0] <= previous[1]) {
                //overlapping
                previous = intArrayOf(previous[0], max(interval[1], previous[1]))
            } else {
                result.add(previous)
                previous = interval
            }
        }
        previous?.let {result.add(it)}
        return result.toTypedArray()
    }
}

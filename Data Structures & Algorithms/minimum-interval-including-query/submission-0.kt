class Solution {
    fun minInterval(intervals: Array<IntArray>, queries: IntArray): IntArray {
        //solution min heap
        intervals.sortBy { it[0] } //sorted by start time
        val sortedQueries = queries.withIndex().sortedBy { it.value} // sorted with index from smallest
        val result = IntArray(queries.size) { -1 }
        val minHeap = PriorityQueue<Pair<Int, Int>>(compareBy {it.first}) // pair of interval size and end time, sorted by first distance

        var intervalIndex = 0
        for(q in sortedQueries) {
            val query = q.value
            val queryIndex = q.index

            // we add to minHeap all interval that start before the query time
            while(intervalIndex != intervals.size) {
                val interval = intervals[intervalIndex]
                if(interval[0] <= query) {
                    val intervalSize = interval[1] - interval[0] + 1
                    minHeap.add(intervalSize to interval[1])
                    intervalIndex++
                    continue
                } else {
                 // start is  bigger then query, cant be used
                    break
                }
            }

            // we try to find interval but we have to remove intervals that end before the query
            var queryResult = -1
            while(minHeap.isNotEmpty()) {
                val (intervalSize, intervalEnd) = minHeap.peek()
                if(intervalEnd >= query) {
                    queryResult = intervalSize
                    break
                } else {
                    minHeap.poll()
                }
            }

            result[queryIndex] = queryResult
        }
        
        return result
    }
}

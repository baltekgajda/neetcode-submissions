class Solution {
    fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {
        val adj = Array<MutableList<Pair<Int,Int>>>(n+1) { mutableListOf()} // end node and time to get there
        val visited = mutableSetOf<Int>()
        val minHeap = PriorityQueue<Pair<Int, Int>>(compareBy {it.second}) // node nr and time to ge there
        var result = 0

        for(time in times) {
            adj[time[0]].add(time[1] to time[2])
        }

        minHeap.add(k to 0)
        while(minHeap.isNotEmpty()) {
            val (node, time) = minHeap.poll()

            if(node in visited)
                continue

            result = max(result, time)
            visited.add(node)

            for((nextNode, dist) in adj[node]) {
                minHeap.add(nextNode to time + dist)
            }
        }

       return if(visited.size == n) {
        result
       } else {
        -1
       }
    }
}

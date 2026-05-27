class Solution {
    fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int {
        val adj = mutableMapOf<Int, MutableList<Pair<Int,Int>>>() //key scr node, value (dst to cost)
        for(flight in flights) {
            adj.getOrPut(flight[0]) {mutableListOf()}.add(flight[1] to flight[2])
        }

        val heap = PriorityQueue<Triple<Int,Int,Int>>(compareBy {it.first}) // Triple(currentCost, node, currentLength)
        heap.add(Triple(0, src, 0))

        while(heap.isNotEmpty()) {
            val (currentCost, node, currentLength) = heap.poll()
            if(currentLength > k + 1) {
                continue
            }

            if(node == dst) {
                return currentCost
            }

            for((neighbor, cost) in adj[node] ?: mutableListOf()) {
                heap.add(Triple(currentCost + cost, neighbor, currentLength+1))
            }
        }
        
        return -1
    }
}

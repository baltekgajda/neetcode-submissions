data class Node(val point: Pair<Int, Int>, val distance: Double)

class Solution {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val minHeap = PriorityQueue<Node>(compareBy {it.distance})

        for((r, c) in points) {
            val distance = kotlin.math.sqrt((r * r).toDouble() + (c * c).toDouble())
            val node = Node(r to c, distance)
            minHeap.add(node)
        }

        val result = mutableListOf<IntArray>()
        for(i in 1 .. k) {
            val node = minHeap.poll()
            result.add(intArrayOf(node.point.first, node.point.second))
        }

        return result.toTypedArray()
    }
}

class Solution {
    fun minCostConnectPoints(points: Array<IntArray>): Int {
        val parent = IntArray(points.size) {it}

        val edges = mutableListOf<Triple<Int, Int, Int>>() // distance, point1 index, point2 index
        for(p in points.indices) {
            for(q in p + 1 until points.size) {
                val distance = kotlin.math.abs(points[p][0] - points[q][0]) + kotlin.math.abs(points[p][1] - points[q][1])
                edges.add(Triple(distance, p, q))
            }
        }

        edges.sortBy { it.first }

        fun find(p: Int): Int {
            var temp = p
            while(temp != parent[temp]) {
                temp = parent[temp]
            }

            return temp
        }

        var trees = points.size
        var edgesIndex = 0
        var cost = 0
        while(trees != 1) {
            val edge = edges[edgesIndex]

            val pParent = find(parent[edge.second])
            val qParent = find(parent[edge.third])

            if(pParent == qParent) {
                edgesIndex++
                continue
            }

            parent[pParent] = qParent
            edgesIndex++
            trees--
            cost+= edge.first
        }

        return cost
    }
}


// 1. generate all distances (edges)
// 2. sort them from smallest to largest weight (distance)
// 3. do union join if parents are different, if the same skip
// 4. continue until all points are connected
// greedy solution where greedy choise is always the best
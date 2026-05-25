class Solution {
    fun manhattanDistance(i: IntArray, j: IntArray): Int {
        return kotlin.math.abs(i[0] - j[0]) + kotlin.math.abs(i[1] - j[1])
    }

    fun minCostConnectPoints(points: Array<IntArray>): Int {
        val visited = BooleanArray(points.size)
        val minCost = IntArray(points.size) { Int.MAX_VALUE }
        minCost[0] = 0
        var totalCost = 0

        repeat(points.size) {
            // Znajdź najtańszy nieodwiedzony punkt
            val u = points.indices.filter { !visited[it] }.minBy { minCost[it] }

            visited[u] = true
            totalCost += minCost[u]

            // Aktualizuj koszty sąsiadów
            for (v in points.indices) {
                if (!visited[v]) {
                    val dist = manhattanDistance(points[u], points[v])
                    minCost[v] = minOf(minCost[v], dist)
                }
            }
        }

        return totalCost
    }
}

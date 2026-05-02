class Solution {
    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        val rows = heights.size
        val columns = heights[0].size
        val directions = listOf(intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(-1, 0))

        val pac = Array(rows) { BooleanArray(columns)}
        val atl = Array(rows) { BooleanArray(columns)}

        fun dfs(ocean: Array<BooleanArray>, point: Pair<Int, Int>) {
            val neighbors = directions.map {Pair(point.first + it[0], point.second + it[1])}
            for((r, c) in neighbors) {
                if(r < 0 || r >= rows || c < 0 || c >= columns) {
                    continue
                }

                if(ocean[r][c]) {
                    continue
                }

                if(heights[r][c] < heights[point.first][point.second]) {
                    continue
                }
                ocean[r][c] = true
                dfs(ocean, r to c)
            }
        }

        val pacPoints = (0 until columns).map {Pair(0, it)} + (0 until rows).map { Pair(it, 0)}
        val atlPoints = (0 until columns).map {Pair(rows-1, it)} + (0 until rows).map { Pair(it, columns-1)}
        for(point in pacPoints) {
            pac[point.first][point.second] = true
            dfs(pac, point)
        }

        for(point in atlPoints) {
            atl[point.first][point.second] = true
            dfs(atl, point)
        }

        atl.forEach {
            println(it.toList())
        }

        val result = mutableListOf<List<Int>>()
        for(r in 0 until rows) {
            for(c in 0 until columns) {
                if(pac[r][c] && atl[r][c]) {
                    result.add(listOf(r,c))
                }
            }
        }

        return result
    }
}
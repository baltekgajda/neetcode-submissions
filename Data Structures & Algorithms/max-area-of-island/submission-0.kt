class Solution {
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        val visited = mutableMapOf<Pair<Int, Int>, Boolean>()
        var maxArea = 0

        for(row in 0 until grid.size) {
            for(column in 0 until grid[0].size) {
                if(grid[row][column] == 0 || (row to column) in visited) {
                    continue
                }

                //1 detected
                val queue = ArrayDeque<Pair<Int,Int>>()
                queue.add(row to column)
                var islandSize = 0
                while(queue.size != 0) {
                    val (r, c) = queue.removeFirst()
                    if((r to c) in visited || grid[r][c] == 0) {
                        continue
                    }

                    islandSize++
                    visited[r to c] = true

                    val directions = listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)
                        .map {r + it.first to c + it.second}
                        .filter {it.first >= 0 && it.first < grid.size && it.second >= 0 && it.second < grid[0].size}

                    queue.addAll(directions)
                }

                maxArea = max(maxArea, islandSize)
            }
        }

        return maxArea
    }
}

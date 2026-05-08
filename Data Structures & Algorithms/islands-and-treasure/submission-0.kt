class Solution {
    fun islandsAndTreasure(grid: Array<IntArray>) {
        val queue = ArrayDeque<Pair<Int,Int>>() //store initially all chests
        val visited = mutableMapOf<Pair<Int, Int>, Boolean>()

        for(row in 0 until grid.size) {
            for(column in 0 until grid[0].size) {
                if(grid[row][column] == 0) {
                    queue.add(row to column)
                    visited[row to column] = true
                } 
            }
        }

        while(queue.size != 0) {
            val (r, c) = queue.removeFirst()

            val neighbors = listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)
                .map { r + it.first to c + it.second }
                .filter { it.first >= 0 && it.first < grid.size && it.second >= 0 && it.second < grid[0].size }
            
            for((nr, nc) in neighbors) {
                if((nr to nc) in visited || grid[nr][nc] == -1) {
                    continue
                }

                grid[nr][nc] = grid[r][c] + 1
                visited[nr to nc] = true
                queue.add(nr to nc)
            }
        }
    }
}

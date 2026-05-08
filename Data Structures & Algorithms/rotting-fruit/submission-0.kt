class Solution {
    fun orangesRotting(grid: Array<IntArray>): Int {
        var result = 0
        var freshBananas = 0
        val queue = ArrayDeque<Pair<Int, Int>>()
        
        for(row in 0 until grid.size) {
            for(column in 0 until grid[0].size) {
                when(grid[row][column]) {
                    2 -> { queue.add(row to column) }
                    1 -> { freshBananas++ }
                    else -> {}
                }
            }
        }

        while(queue.size != 0 && freshBananas != 0) {
            val (row, column) = queue.removeFirst()
            val neighbors = listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)
                .map {row + it.first to column + it.second}
                .filter {it.first >= 0 && it.first < grid.size && it.second >= 0 && it.second < grid[0].size}

            for((nr, nc) in neighbors) {
                if(grid[nr][nc] != 1) {
                    continue
                }

                freshBananas--
                grid[nr][nc] = grid[row][column] + 1
                queue.add(nr to nc)
                result = max(result, grid[nr][nc] - 2)
            }

        }

        return if(freshBananas != 0) {
            -1
        } else {
            result
        }
    }
}

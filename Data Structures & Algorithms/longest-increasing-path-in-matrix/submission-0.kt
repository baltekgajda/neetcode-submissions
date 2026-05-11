class Solution {
    fun longestIncreasingPath(matrix: Array<IntArray>): Int {
        val indegree = mutableMapOf<Pair<Int, Int>, Int>()
        val queue = ArrayDeque<Pair<Int, Int>>()

        for(row in 0 until matrix.size) {
            for(column in 0 until matrix[0].size) {
                val neighbors = listOf(1 to 0, -1 to 0, 0 to 1, 0 to -1)
                    .map {row + it.first to column + it.second}
                    .filter {it.first >= 0 && it.first < matrix.size && it.second >= 0 && it.second < matrix[0].size}
                    .filter {matrix[row][column] > matrix[it.first][it.second]}
                    .size

                indegree[row to column] = neighbors
                if(neighbors == 0) {
                    queue.addLast(row to column)
                }
            }
        }

        var result = 0
        while(queue.isNotEmpty()) {
            result++
            repeat(queue.size) {
                val (row, column) = queue.removeFirst()
                val neighbors = listOf(1 to 0, -1 to 0, 0 to 1, 0 to -1)
                    .map {row + it.first to column + it.second}
                    .filter {it.first >= 0 && it.first < matrix.size && it.second >= 0 && it.second < matrix[0].size}
                    .filter {matrix[row][column] < matrix[it.first][it.second]}
                
                for((nr, nc) in neighbors) {
                    indegree[nr to nc] = indegree[nr to nc]!! - 1
                    if(indegree[nr to nc] == 0) {
                        queue.addLast(nr to nc)
                    }
                }
            }   
        }

        return result
    }
}

class Solution {
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        val parent = IntArray(grid.size * grid[0].size) { it }
        val rank = IntArray(grid.size * grid[0].size) { 1 }

        fun find(node: Int): Int {
            var head = node
            while(parent[head] != head) {
                head = parent[head]
            }
            return head
        }

        fun union(node1: Int, node2: Int): Int {
            val (parent1, parent2) = find(node1) to find(node2)
            if(parent1 == parent2) {
                return rank[parent1]
            }

            return if(rank[parent1] >= rank[parent2]) {
                rank[parent1] += rank[parent2]
                parent[parent2] = parent1
                rank[parent1]
            } else {
                rank[parent2] += rank[parent1]
                parent[parent1] = parent2
                rank[parent2]
            }
        }
        
        fun getIndex(r: Int, c: Int): Int = r*(grid[0].size) + c
        var maxRank = 0
        

        for(row in 0 until grid.size) {
            for(column in 0 until grid[0].size) {
                if(grid[row][column] == 0) {
                    continue
                }

                //1 found
                maxRank = max(maxRank, 1)
                val directions = listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)
                    .map {row + it.first to column + it.second}
                    .filter {it.first >= 0 && it.first < grid.size && it.second >= 0 && it.second < grid[0].size}
                    .filter {grid[it.first][it.second] == 1}

                for((r,c) in directions) {
                    val currentSize = union(getIndex(r, c), getIndex(row, column))
                    maxRank = max(maxRank,currentSize)
                }
            }
        }

        return maxRank
    }
}

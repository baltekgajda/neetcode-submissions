class Solution {
    fun swimInWater(grid: Array<IntArray>): Int {
        //dixtra search
        val minHeap = PriorityQueue<IntArray>(compareBy { it[2] }) //int array with (x, y, max_elevation)
        val visited = mutableSetOf<Pair<Int,Int>>()
        
        minHeap.add(intArrayOf(0,0,grid[0][0]))
        while(minHeap.isNotEmpty()) {
            val node = minHeap.poll()
            val (row, column) = node[0] to node[1]
            val maxElevation = node[2]

            if(row == grid.size - 1 && column == grid[0].size - 1) {
                return maxElevation
            }

            visited.add(row to column)

            val neighbors = listOf(1 to 0, -1 to 0, 0 to 1, 0 to -1) //!!!mozna we wszystkich kierunkach!!!!!
                .map { row + it.first to column + it.second}
                .filter { it.first >= 0 && it.first < grid.size && it.second >= 0 && it.second < grid[0].size }
                .filter { it !in visited }
            
            for((nr, nc) in neighbors) {
                minHeap.add(intArrayOf(nr, nc, max(maxElevation, grid[nr][nc])))
            }
        }

        return 0
    }
}

class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        var islands = 0
        val visited = mutableSetOf<Pair<Int,Int>>()

        fun checkNeighbor(row: Int, column: Int) {
            if(row < 0 || row == grid.size || column < 0 || column == grid[0].size) {
                return
            }

            val point = row to column
            if(point in visited || grid[row][column] == '0') {
                return
            }

            visited.add(point)
            checkNeighbor(row+1,column)
            checkNeighbor(row,column+1)
            checkNeighbor(row-1,column)
            checkNeighbor(row,column-1)
        }

        for(row in 0 until grid.size) {
            for(column in 0 until grid[0].size) {
                val point = row to column
                if(point in visited || grid[row][column] == '0') {
                    continue
                }

                islands++
                visited.add(point)
                checkNeighbor(row+1,column)
                checkNeighbor(row,column+1)
                checkNeighbor(row-1,column)
                checkNeighbor(row,column-1)
            }
        }

        return islands
    }
}

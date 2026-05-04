class Solution {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        var visited = mutableSetOf<Pair<Int,Int>>()

        fun findChar(row: Int, column: Int, wordIndex: Int): Boolean {
            if(wordIndex == word.length) {
                return true
            }

            val neighbors = listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)
                .map {(row + it.first) to (column + it.second)}
                .filter { it !in visited}

            for((x,y) in neighbors) {
                if(x < 0 || x >= board.size || y < 0 || y >= board[0].size) {
                    continue
                }

                if(board[x][y] == word[wordIndex]) {
                    visited.add(x to y)

                    if(findChar(x,y,wordIndex+1)) {
                        return true
                    }

                    visited.remove(x to y)
                }
            }

            return false
        }

        for(row in 0 until board.size) {
            for(column in 0 until board[0].size) {
                if(board[row][column] == word[0]) {
                    visited.add(row to column)

                    if(findChar(row,column,1)) {
                        return true
                    }

                    visited.remove(row to column)
                }
            }
        }
        return false
    }
}

// 1. create mutableset of used chars in one loop of searching containing visited and used chars
// 2. after each loop we remove the last visited char
// 3. outer loop searches for first letter in the whole board
// 4. if we already have the first letter we iterate though next letters dfs style, pointing as visited 
// 5. we iterate only in four directions as grid is
// 6. if we iterated over all letters we found the word
class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        for(row in 0 until 9) {
            val rowSet = mutableSetOf<Char>()
            for(column in 0 until 9) {
                val item = board[row][column]
                if(item == '.') {
                    continue
                }

                if(item in rowSet) {
                    return false
                }

                rowSet.add(item)
            }
        }

        for(column in 0 until 9) {
            val columnSet = mutableSetOf<Char>()
            for(row in 0 until 9) {
                val item = board[row][column]
                if(item == '.') {
                    continue
                }

                if(item in columnSet) {
                    return false
                }

                columnSet.add(item)
            }
        }

        for(rowNine in 0 until 3) {
            for(columnNine in 0 until 3) {
                val squareSet = mutableSetOf<Char>()
                for(row in 0 until 3) {
                    for(column in 0 until 3) {
                        val item = board[row + 3*rowNine][column + 3*columnNine]
                        if(item == '.') {
                            continue
                        }

                        if(item in squareSet) {
                            return false
                        }

                        squareSet.add(item)
                    }
                }
            }
        } 
        
        return true
    }
}
class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val rows = Array<MutableSet<Char>>(9) { mutableSetOf()}
        val columns = Array<MutableSet<Char>>(9) { mutableSetOf()}
        val squares = Array<MutableSet<Char>>(9) { mutableSetOf()}

        for(row in 0 until 9) {
            for(column in 0 until 9) {
                val item = board[row][column]
                if(item == '.') {
                    continue
                }
                
                if(item in rows[row] || item in columns[column] || item in squares[(row/3) * 3 + (column/3) ]) {
                    return false
                }

                rows[row].add(item)
                columns[column].add(item)
                squares[(row/3) * 3 + (column/3) ].add(item)
            }
        }
        
        return true
    }
}
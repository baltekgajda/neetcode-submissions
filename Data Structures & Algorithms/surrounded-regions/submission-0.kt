class Solution {
    fun solve(board: Array<CharArray>) {

        val rows = board.size
        val columns = board[0].size

        fun dfs(r: Int, c: Int) {
            if(r < 0 || r >= rows || c < 0 || c >= columns) {
                return
            }

            if(board[r][c] != 'O') {
                return
            }

            board[r][c] = 'T'

            dfs(r+1, c)
            dfs(r-1, c)
            dfs(r, c+1)
            dfs(r, c-1)
        }

        for(r in 0 until rows) {
            if(board[r][0] == 'O') {
                dfs(r, 0)
            }

            if(board[r][columns-1] == 'O') {
                dfs(r, columns-1)
            }
        }

        for(c in 0 until columns) {
            if(board[0][c] == 'O') {
                dfs(0, c)
            }

            if(board[rows-1][c] == 'O') {
                dfs(rows-1, c)
            }
        }

        for(r in 0 until rows) {
            for(c in 0 until columns) {
                board[r][c] = when(board[r][c]) {
                    'T' -> 'O'
                    else -> 'X'
                }
            }
        }
    }
}

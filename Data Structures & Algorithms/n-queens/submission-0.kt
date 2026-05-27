class Solution {
    fun solveNQueens(n: Int): List<List<String>> {
        val chars = CharArray(n) {'.'}
        val options = Array<String>(n) {""}
        for(i in 0 until n) {
            chars[i] = 'Q'
            options[i] = String(chars)
            chars[i] = '.'
        }

        val usedColumns = mutableSetOf<Int>()
        val usedDiagonalsAdd = mutableSetOf<Int>()  //points on same left diagonal have same sum row + columnt
        val usedDiagonalsSub = mutableSetOf<Int>() //points on same right diagonal have same subtraction row - column

        val current = mutableListOf<String>()
        val result = mutableListOf<List<String>>()

        fun permutation(row: Int) {
            if(current.size == n) {
                result.add(current.toList())
                return
            }

            for(i in 0 until n) {
                if(i in usedColumns || (row + i) in usedDiagonalsAdd ||  (row - i) in usedDiagonalsSub) {
                    continue
                }

                usedColumns.add(i)
                usedDiagonalsAdd.add(row + i)
                usedDiagonalsSub.add(row - i)
                current.add(options[i])

                permutation(row+1)

                usedColumns.remove(i)
                usedDiagonalsAdd.remove(row + i)
                usedDiagonalsSub.remove(row - i)
                current.removeLast()
            }
        }

        permutation(0)
        return result
    }
}

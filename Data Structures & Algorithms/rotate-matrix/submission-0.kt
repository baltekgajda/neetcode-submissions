class Solution {
    fun rotate(matrix: Array<IntArray>) {
        val matrixSize = matrix.size
        for(row in 0 until matrixSize) {
            for(column in 0 until matrixSize) {
                if(row >= column) {
                    continue
                }

                val temp = matrix[row][column]
                matrix[row][column] = matrix[column][row]
                matrix[column][row] = temp
            }
        }

        for(row in 0 until matrix.size) {
            for(column in 0 until matrixSize/2) {
                val temp = matrix[row][column]
                val otherColumn = kotlin.math.abs(column-matrixSize+1)
                matrix[row][column] = matrix[row][otherColumn]
                matrix[row][otherColumn] = temp
            }
        }
    }

    // 1. flip array along axis from 0,0 to n,n (only iterate over upper triangle)
    // 2. flip array horizontally (left to right index)
    // O(2n = n)
}

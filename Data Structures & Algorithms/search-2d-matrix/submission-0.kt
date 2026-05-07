class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val rows = matrix.size
        val columns = matrix[0].size
        val matrixSize = rows * columns

        fun getIndices(index: Int): Pair<Int, Int> {
            val row = index / columns
            val column = index % columns

            return row to column
        }

        fun getValue(row: Int, column: Int): Int {
            return matrix[row][column]
        }

        // end excluded
        fun binarySearch(start: Int, end: Int): Boolean {
            val (startR, startC) = getIndices(start)
            val (endR, endC) = getIndices(end-1)
            val startValue = getValue(startR, startC)
            val endValue = getValue(endR, endC)

            if(target < startValue || target > endValue) {
                return false
            }

            if(target == startValue || target == endValue) {
                return true
            }

            val middleIndex = (start + end)/2
            val (middleR, middleC) = getIndices(middleIndex)
            val middleValue = getValue(middleR, middleC)
            return if(target == middleValue) {
                true
            } else if(target < middleValue) {
                binarySearch(start, middleIndex)
            } else {
                binarySearch(middleIndex+1, end)
            }
        }

        return binarySearch(0, matrixSize)
    }
}

class Solution {
    fun rotate(matrix: Array<IntArray>) {
        var left = 0
        var right = matrix.size - 1
        while(left < right) {
            for(i in 0 until right-left) {
                val topLeft = matrix[left][left+i]

                // top left
                matrix[left][left+i] = matrix[right-i][left]

                //bottom left
                matrix[right-i][left] = matrix[right][right-i]

                //top right
                matrix[right][right-i] = matrix[left+i][right]
                
                matrix[left+i][right] = topLeft
            }

            left++
            right--
        }
    }

}

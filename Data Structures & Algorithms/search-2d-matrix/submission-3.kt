class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        var l = 0
        var r = matrix.size * matrix[0].size - 1

        while(l<=r) {
            val middle = (l+r)/2
            val item = matrix[middle / matrix[0].size][middle % matrix[0].size]

            when {
                item == target -> return true
                target > item -> {
                    l = middle+1
                }
                else -> {
                    r = middle-1
                }
            }
        }

        return false
    }
}

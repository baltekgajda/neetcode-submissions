class Solution {
    fun setZeroes(matrix: Array<IntArray>) {
        var zeroRowClear = false
        var zeroColumnClear = false

        for(row in 0 until matrix.size) {
            for(column in 0 until matrix[0].size) {
                if(matrix[row][column] == 0) {
                    matrix[0][column] = 0
                    matrix[row][0] = 0

                    if(column == 0) {
                        zeroColumnClear = true
                    }

                    if(row == 0) {
                        zeroRowClear = true
                    }
                }
            }
        } 

        for(row in 1 until matrix.size) {
            if(matrix[row][0] == 0) {
                for(column in 0 until matrix[0].size) {
                    matrix[row][column] = 0
                }
            }
        }

        for(column in 1 until matrix[0].size) {
            if(matrix[0][column] == 0) {
                for(row in 0 until matrix.size) {
                    matrix[row][column] = 0
                }
            }
        }

        if(zeroRowClear) {
            for(column in 0 until matrix[0].size) {
                matrix[0][column] = 0
            }
        }

        if(zeroColumnClear) {
            for(row in 0 until matrix.size) {
                matrix[row][0] = 0
            }
        }
    }
}

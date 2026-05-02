class Solution {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        var leftBound = 0 //inclusive
        var rightBound = matrix[0].size //exclusive
        var upperBound = 0 //inclusive
        var lowerBound = matrix.size //exclusive

        val result = mutableListOf<Int>()
        val elemsCount = matrix.size * matrix[0].size
        while(result.size != elemsCount) {
                // upper row 
                for(i in leftBound until rightBound) {
                    result.add(matrix[upperBound][i])
                }
                upperBound += 1

                // right column
                if(result.size == elemsCount) return result
                for(i in upperBound until lowerBound) {
                    result.add(matrix[i][rightBound-1])
                }
                rightBound -= 1

                // lower row
                if(result.size == elemsCount) return result
                for(i in rightBound-1 downTo leftBound) {
                    result.add(matrix[lowerBound-1][i])
                }
                lowerBound -= 1

                // left column
                if(result.size == elemsCount) return result
                for(i in lowerBound-1 downTo upperBound) {
                    result.add(matrix[i][leftBound])
                }
                leftBound += 1
        }

        return result
    }
}

class Solution {
    fun uniquePaths(m: Int, n: Int): Int {
        val ar = mutableMapOf<Pair<Int, Int>, Int>()
        ar[0 to 0] = 1

        for(row in 0 until m) {
            for(column in 0 until n) {
                if(row == 0 && column == 0) {
                    continue
                }

                ar[row to column] = (ar[row to column-1] ?: 0)+ (ar[row-1 to column] ?: 0)
            }
        }

        return ar[m-1 to n-1]!!
    }
}
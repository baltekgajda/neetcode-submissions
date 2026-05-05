class Solution {
    fun uniquePaths(m: Int, n: Int): Int {
        // there will be m-1 + n-1 moves in total to get to goal = m+n-1
        // we choose m-1 places to place down movements inside all movements 
        // we do that with binominal coefficient m+n - 1 over m - 1

        if (m == 1 || n == 1) return 1
        var m = m
        var n = n
        if (m < n) {
            val tmp = m
            m = n
            n = tmp
        }

        var res: Long = 1
        var j = 1
        for (i in m until m + n - 1) {
            res *= i
            res /= j
            j++
        }

        return res.toInt()
    }
}
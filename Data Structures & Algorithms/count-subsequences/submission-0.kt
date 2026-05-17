class Solution {
    fun numDistinct(s: String, t: String): Int {
        val memo = mutableMapOf<Pair<Int,Int>, Int>()

        fun check(i: Int, j: Int): Int {
            if(s.length - i < t.length - j) {
                return 0
            }

            if(j == t.length) {
                return 1
            }

            if(i to j in memo) {
                return memo[i to j]!!
            }

            return if(s[i] != t[j]) {
                val result = check(i+1, j)
                memo[i to j] = result
                result
            } else {
                val result = check(i+1, j+1) + check(i+1, j)
                memo[i to j] = result
                result
            }
        }

        return check(0,0)
    }
}

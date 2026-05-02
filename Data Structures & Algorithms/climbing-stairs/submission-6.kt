class Solution {
    fun climbStairs(n: Int): Int {
        val cache = IntArray(n+1){-1}

        fun dp(i: Int): Int {
            return when {
                i > n -> 0
                i == n -> 1
                else -> {
                    if(cache[i] != -1) {
                        cache[i]
                    } else {
                        cache[i] = dp(i+1) + dp(i+2)
                        cache[i]
                    }
                }
            }
        }

        return dp(0)
    }
}

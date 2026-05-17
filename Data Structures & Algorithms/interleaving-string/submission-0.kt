class Solution {
    fun isInterleave(s1: String, s2: String, s3: String): Boolean {
        if(s3.length != (s1.length + s2.length)) {
            return false
        }

        val memo = mutableMapOf<Pair<Int,Int>, Boolean>()

        fun isThat(i: Int, j: Int): Boolean {
            if(i == s1.length && j == s2.length && i + j == s3.length) {
                memo[i to j] = true
                return true
            }

            if(i to j in memo) {
                return memo[i to j]!!
            }

            if(i == s1.length && j == s2.length) {
                memo[i to j] = false
                return false
            }

            if(i < s1.length && s3[i+j] == s1[i]) {
                val result = isThat(i+1, j)
                if(result) {
                    memo[i to j]= true
                    return true
                }
            }

            if(j < s2.length && s3[i+j] == s2[j]) {
                val result = isThat(i, j+1)
                if(result) {
                    memo[i to j]= true
                    return true
                }
            }

            memo[i to j] = false
            return false
        }

        return isThat(0,0)
    }
}

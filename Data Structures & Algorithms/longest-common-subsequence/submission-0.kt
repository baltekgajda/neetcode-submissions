class Solution {
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        val memo = mutableMapOf<Pair<Int,Int>, Int>()
        fun dfs(first: Int, second: Int): Int {
            if(first == text1.length || second == text2.length) {
                return 0
            }

            if((first to second) in memo) {
                return memo[first to second]!!
            }

            val skipFirst = dfs(first+1, second)
            val skipSecond = dfs(first, second+1)
            val charsMatch = if(text1[first] == text2[second]) 1 else 0
            val skipBoth = dfs(first+1, second+1) + charsMatch

            val result = listOf(skipFirst, skipSecond, skipBoth).max()
            memo[first to second] = result
            return result            
        }

        return dfs(0, 0)
    }
}

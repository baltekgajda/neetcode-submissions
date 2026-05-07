class Solution {
    fun change(amount: Int, coins: IntArray): Int {
        val memo = mutableMapOf<Pair<Int,Int>, Int>() // first coin to use index

        fun dfs(goal: Int, firstCoinIndex: Int): Int {
            if((goal to firstCoinIndex) in memo) {
                return memo[goal to firstCoinIndex]!!
            }

            if(goal < 0 || firstCoinIndex >= coins.size) {
                return 0
            }

            if(goal == 0) {
                return 1
            }

            val first = coins[firstCoinIndex]
            val result = dfs(goal-first, firstCoinIndex) + dfs(goal, firstCoinIndex+1)
            memo[goal to firstCoinIndex] = result
            return result
        }

        return dfs(amount, 0)
    }
}
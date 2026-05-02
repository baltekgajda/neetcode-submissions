class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        //top down

        val memo = mutableMapOf<Int,Int>()
        memo[0] = 0

        fun minCoins(a: Int): Int {
            if(a < 0) {
                return -1
            }

            if(a in memo) {
                return memo[a]!!
            }

            val result = coins
            .map { a-it }
            .map { minCoins(it)}
            .filter { it >= 0}
            .map { it + 1 }
            .minOrNull() ?: -1

            memo[a] = result ?: -1
            return result ?: -1
        }

        return minCoins(amount)
    }
}
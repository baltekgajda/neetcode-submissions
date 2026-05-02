class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        //bottom up
        val memo = mutableMapOf<Int, Int>()
        memo[0] = 0
        
        val ar = ArrayDeque<Int>()
        for(i in 1 .. amount) {
            var currentMin = Int.MAX_VALUE
            for(c in coins) {
                val rem = i-c
                if(rem < 0 || memo[rem] == -1) {
                    continue
                }

                currentMin = min(currentMin, memo[rem]!! + 1)
            }
            memo[i] = if(currentMin == Int.MAX_VALUE) -1 else currentMin
        }

        println(memo)
        return memo[amount]!!
    }
}
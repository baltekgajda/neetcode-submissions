class Solution {
    fun change(amount: Int, coins: IntArray): Int {
        val memo = IntArray(amount + 1)
        memo[0] = 1

        for(i in 0 until coins.size) {
            for(a in 1..amount) {
                if(a - coins[i] >= 0) {
                    memo[a] += memo[a - coins[i]]
                }
            }
        }

        return memo[amount]
    }
}

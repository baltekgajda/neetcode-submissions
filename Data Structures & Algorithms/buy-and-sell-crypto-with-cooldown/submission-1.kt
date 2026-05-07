class Solution {
    fun maxProfit(prices: IntArray): Int {
        val memo = mutableMapOf<Pair<Int,Boolean>, Int>()
        
        fun profit(day: Int, holding: Boolean): Int {
            if(day >= prices.size) {
                return 0
            }

            if((day to holding) in memo) {
                return memo[day to holding]!!
            }

            var maxResult = 0

            //skip
            maxResult = max(maxResult, profit(day+1, holding))

            //sell
            if(holding) {
                maxResult = max(maxResult, profit(day+2, false) + prices[day])
            }

            //buy
            if(!holding) {
                maxResult = max(maxResult, profit(day+1, true) - prices[day])
            }
            
            memo[day to holding] = maxResult
            return maxResult
        }

        return profit(0, false)
    }
}

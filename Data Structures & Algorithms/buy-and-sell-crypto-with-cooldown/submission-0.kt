class Solution {
    fun maxProfit(prices: IntArray): Int {
        val memo = mutableMapOf<Pair<Int,Int?>, Int>()
        
        fun profit(day: Int, boughtIndex: Int?): Int {
            if(day >= prices.size) {
                return 0
            }

            if((day to boughtIndex) in memo) {
                return memo[day to boughtIndex]!!
            }

            var maxResult = 0
            if(boughtIndex != null && prices[day]!! > prices[boughtIndex!!]) {
                maxResult = max(maxResult, profit(day+2, null) +  prices[day] - prices[boughtIndex!!])
            }

            if(boughtIndex == null) {
                maxResult = max(maxResult, profit(day+1, day))
            }

            maxResult = max(maxResult, profit(day+1, boughtIndex))
            memo[day to boughtIndex] = maxResult
            return maxResult
        }

        return profit(0, null)
    }
}

class Solution {
    fun maxProfit(prices: IntArray): Int {
       var maxP = 0
       var lowest = Int.MAX_VALUE

       for(sell in prices) {
        maxP = maxOf(maxP, sell-lowest)
        lowest = minOf(lowest, sell)
       }

       return maxP
    }
}

class Solution {
    fun maxProfit(prices: IntArray): Int {
        var l = 0
        var r = 1
        var maxP = 0

        while (r < prices.size) {
            if(prices[l] < prices[r]) {
                val profit = prices[r] - prices[l]
                maxP = max(maxP, profit)
            } else {
                l = r
            }
            r++
        }

        return maxP
    }
}

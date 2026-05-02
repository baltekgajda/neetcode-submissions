class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {
        val minCosts = IntArray(cost.size+1) {0}
        for(i in 0..cost.size) {
            val costMinus2 = minCosts.getOrElse(i-2) {0} + cost.getOrElse(i-2) {0}
            val costMinus1 = minCosts.getOrElse(i-1) {0} + cost.getOrElse(i-1) {0}
            minCosts[i] = min(costMinus2, costMinus1)
        }

        return minCosts[cost.size]
    }
}

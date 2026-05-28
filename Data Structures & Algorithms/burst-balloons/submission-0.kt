class Solution {
    fun maxCoins(nums: IntArray): Int {
        val newNums = intArrayOf(1) + nums + intArrayOf(1)
        val memo = mutableMapOf<Pair<Int,Int>, Int>()

        //start - inclusive, end - inclusive, returns number pf coins to get there
        fun rec(start: Int, end: Int): Int {
            if (start > end) return 0
            
            if(start to end in memo) {
                return memo[start to end]!!
            }

            var best = 0

            for(i in start..end) {
                //nums[i] is the last one to pop
                val coins = newNums[start-1] * newNums[i] * newNums[end+1]
                val totalCoins = coins + rec(start, i - 1) + rec(i+1, end)              
                best = max(best, totalCoins)
            }

            memo[start to end] = best
            return best
        }

        return rec(1, nums.size)
    }
}
class Solution {
    fun lengthOfLIS(nums: IntArray): Int {

        val memo = mutableMapOf<Pair<Int,Int>,Int>()
        
        fun dfs(start: Int, lastIncludedIndex: Int): Int {
            if(start >= nums.size) {
                return 0
            }

            if((start to lastIncludedIndex) in memo) {
                return memo[start to lastIncludedIndex]!!
            }

            //not include
            var LIS = dfs(start+1, lastIncludedIndex)

            //include
            if(lastIncludedIndex == -1 || nums[lastIncludedIndex] < nums[start]) {
                LIS = maxOf(LIS, 1 + dfs(start+1, start))
            }

            memo[start to lastIncludedIndex] = LIS
            return LIS
        }

        return dfs(0, -1)
    }
}

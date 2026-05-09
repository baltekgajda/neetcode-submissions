class Solution {
    fun canPartition(nums: IntArray): Boolean {
        val numsSum = nums.sum() % 2
        if(numsSum % 2 == 1) {
            return false
        }

        val memo = mutableMapOf<Pair<Int,Int>, Boolean>()

        fun dfs(index: Int, target: Int): Boolean {
            if(index >= nums.size) {
                return false
            }

            if(index to target in memo) {
                return memo[index to target]!!
            }

            if(target == 0) {
                return true
            }

            if(target < 0) {
                return false
            }

            //decide if num at index goes into sum or not
            val result = dfs(index+1, target-nums[index]) || dfs(index+1, target)
            memo[index to target] = result
            return result 
        }

        return dfs(0, nums.sum() / 2)
    }
}

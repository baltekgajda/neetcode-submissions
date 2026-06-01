class Solution {
    fun combinationSum4(nums: IntArray, target: Int): Int {

        val memo = mutableMapOf<Int, Int>()

        fun dfs(sum: Int): Int {
            if(sum in memo) {
                return memo[sum]!!
            }
        
            if(sum == 0) {
                return 1
            }

            if(sum < 0) {
                return 0
            }

            var result = 0
            for(n in nums) {
                val rem = sum - n
                result += dfs(rem)
            }

            memo[sum] = result

            return result
        }

        return dfs(target)
    }
}

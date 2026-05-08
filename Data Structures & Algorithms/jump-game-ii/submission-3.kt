class Solution {
    fun jump(nums: IntArray): Int {
        val memo = IntArray(nums.size) {Int.MAX_VALUE}
        memo[0] = 0

        for(i in 0 until nums.size-1) {
            for(j in 1 .. nums[i]) {
                if(i+j >= nums.size) {
                    break
                }
                
                memo[i+j] = min(memo[i+j], memo[i] + 1)
            }
        } 

        return memo[nums.size-1]
    }
}

class Solution {
    fun canJump(nums: IntArray): Boolean {
        val memo = mutableMapOf<Int, Boolean>()
        memo[nums.size-1] = true
        for(i in nums.size-1 downTo 0) {
            val result = (0..nums[i]).toList().any {memo[i+it] ?: false}
            memo[i] = result
        }

        println(memo.toList())
        return memo[0]!!
    }
}

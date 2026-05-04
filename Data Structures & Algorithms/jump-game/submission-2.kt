class Solution {
    fun canJump(nums: IntArray): Boolean {
        if(nums.size == 1) {
            return true
        }

        var end = nums.size - 1
        for(i in nums.size-1 downTo 0) {
            if(nums[i]+i >= end) {
                end = i
            } 
        }

        return end == 0
    }
}

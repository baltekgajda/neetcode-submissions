class Solution {
    fun findDuplicate(nums: IntArray): Int {
        for(n in nums) {
            val absN = kotlin.math.abs(n)
            if(nums[absN] < 0) {
                return absN
            } else {
                nums[absN] = 0 - nums[absN]
            }
        }

        return -1
    }
}

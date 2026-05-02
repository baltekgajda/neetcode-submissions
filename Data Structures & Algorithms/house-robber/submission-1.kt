class Solution {
    fun rob(nums: IntArray): Int {
        var prev = 0
        var twoBefore = 0
        for(i in 0 until nums.size) {
            val temp = max(twoBefore+nums[i], prev)
            twoBefore = prev
            prev = temp
        }

        return max(twoBefore, prev)
    }
}

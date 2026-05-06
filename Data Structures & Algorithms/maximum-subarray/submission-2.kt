class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var result = Int.MIN_VALUE
        var prev = 0
        for(i in 0 until nums.size) {
            val sub = prev + nums[i]
            if(sub > nums[i]) {
                prev = sub
            } else {
                prev = nums[i]
            }
            result = max(result, prev)
        }

        return result
    }
}

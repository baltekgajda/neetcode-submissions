class Solution {
    fun maxSubArray(nums: IntArray): Int {
        //brute force
        var result = Int.MIN_VALUE
        for(i in 0 until nums.size) {
            var currentSum = nums[i]
            result = max(currentSum, result)
            for(j in i+1 until nums.size) {
                currentSum += nums[j]
                result = max(currentSum, result)
            }
        }

        return result
    }
}

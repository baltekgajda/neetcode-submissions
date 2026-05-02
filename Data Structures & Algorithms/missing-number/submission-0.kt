class Solution {
    fun missingNumber(nums: IntArray): Int {
        val sum = nums.sum()
        val maxSum = (nums.size * (nums.size + 1))/2
        return maxSum - sum
    }
}



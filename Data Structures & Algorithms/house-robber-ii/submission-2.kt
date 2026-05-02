class Solution {
    fun rob(nums: IntArray): Int {
        if(nums.size <= 3) {
            return nums.max()
        }

        return max(robHouses(nums, 0, nums.size-1), robHouses(nums, 1, nums.size))
    }

    fun robHouses(nums: IntArray, start: Int, end: Int): Int {
        var prev2 = 0
        var prev1 = 0

        for(i in start until end) {
            val temp = max(prev1, prev2 + nums[i])
            prev2 = prev1
            prev1 = temp
        }

        return prev1
    }
}

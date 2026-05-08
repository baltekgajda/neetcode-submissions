class Solution {
    fun jump(nums: IntArray): Int {
        var left = 0
        var right = 0 // inclusive
        var result = 0

        while(right < nums.size - 1) {
            var maxRight = 0
            for(i in left .. right) {
                maxRight = max(maxRight, nums[i] + i)
            }

            left = right + 1
            right = maxRight
            result++
        }

        return result
    }
}

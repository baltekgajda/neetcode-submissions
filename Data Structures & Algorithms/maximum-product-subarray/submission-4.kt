class Solution {
    fun maxProduct(nums: IntArray): Int {
        var (minP, maxP) = 1 to 1
        var maxValue = nums.max()
        for(i in 0 until nums.size) {
            if(nums[i] == 0) {
                minP = 1
                maxP = 1
                continue
            }
            val first = minP * nums[i]
            val second = maxP * nums[i]
            minP = listOf(first, second, nums[i]).min()
            maxP = listOf(first, second, nums[i]).max()
            maxValue = max(maxValue, maxP)
        }

        return maxValue
    }
}

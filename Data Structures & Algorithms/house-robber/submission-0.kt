class Solution {
    fun rob(nums: IntArray): Int {
        val twoStepsAfter = IntArray(nums.size) {0}
        for(i in nums.size-1 downTo 0) {
            nums[i] = nums[i] + twoStepsAfter[i]

            if(i >= 1) {
                twoStepsAfter[i-1] = max(nums.getOrElse(i+1) {0}, twoStepsAfter[i])
            }
        }

        return max(nums[0], nums.getOrElse(1) {0})
    }
}

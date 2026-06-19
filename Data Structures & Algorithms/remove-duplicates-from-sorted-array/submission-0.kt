class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var firstIndex = 0
        for(i in 1 until nums.size) {
            if(nums[i] == nums[firstIndex]) {
                continue
            } else {
                firstIndex++
                nums[firstIndex] = nums[i]
            }
        }

        return firstIndex + 1
    }
}

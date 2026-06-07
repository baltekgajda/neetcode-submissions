class Solution {
    fun sortColors(nums: IntArray) {
        var redIndex = 0
        var blueIndex = nums.size -1
        var i = 0
        while(i <= blueIndex) {
            when(nums[i]) {
                0 -> {
                    val temp = nums[redIndex]
                    nums[redIndex] = 0
                    nums[i] = temp
                    redIndex++
                }
                2 -> {
                    val temp = nums[blueIndex]
                    nums[blueIndex] = 2
                    nums[i] = temp
                    blueIndex--
                    i--
                }
                else -> {}
            }
            i++
        }
    }
}
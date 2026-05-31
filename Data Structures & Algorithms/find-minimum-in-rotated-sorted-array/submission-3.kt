class Solution {
    fun findMin(nums: IntArray): Int {
        var left = 0
        var right = nums.size -1


        while(left<=right) {
            if(left == right) {
                return nums[left]
            }

            val middle = (left+right)/2

            when {
                nums[middle] < nums[right] -> {
                    right = middle
                }
                else -> {
                    left = middle+1
                }
            }
        }

        return -1
    }
}

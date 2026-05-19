class Solution {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1

        while(left<=right) {
            val middle = (left+right)/2

            if(nums[middle] == target) {
                return middle
            }

            if(target > nums[middle]) {
                left = middle + 1
            } else {
                right = middle - 1
            }
        }

        return max(left,right)
    }
}

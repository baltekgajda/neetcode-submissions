class Solution {
    fun findMin(nums: IntArray): Int {
        var l = 0
        var r = nums.size - 1
        while(l<=r) {
            val middle = (l+r)/2
            
            if(nums[l] <= nums[middle] && nums[middle] <= nums[r]) {
                return nums[l]
            }

            if(nums[l] <= nums[middle]) {
                l = middle + 1
            } else {
                r = middle
            }
        }

        return 0
    }
}

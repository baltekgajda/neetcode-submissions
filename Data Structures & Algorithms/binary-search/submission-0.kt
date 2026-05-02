class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var start = 0
        var end = nums.size - 1
        var middle = end/2   

        while(true) {
            if(end-start <= 1) {
                return if(target == nums[start]) {
                    start
                } else if(target == nums[end]) {
                    end
                } else {
                    -1
                }
            }

            if(target <= nums[middle]) {
                end = middle
            } else {
                start = middle
            }
            middle = (end-start)/2+start
        }
    }
}

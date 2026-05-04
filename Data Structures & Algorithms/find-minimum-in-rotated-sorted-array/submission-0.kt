class Solution {
    fun findMin(nums: IntArray): Int {
        if(nums.size == 1) {
            return nums[0]
        }

        //end excluded
        fun binarySearch(start: Int, end: Int): Int {
            if(end-start == 1) {
                return nums[start]
            }

            if(nums[start] < nums[end-1]) {
                return nums[start]
            }

            val middle = (end-start)/2+start
            return min(binarySearch(start, middle), binarySearch(middle,end))
        }

        return binarySearch(0, nums.size)
    }
}

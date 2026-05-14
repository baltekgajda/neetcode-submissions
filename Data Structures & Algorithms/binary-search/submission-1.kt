class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.size - 1
        while(l<=r) {
            val middle = (l+r)/2
            val item = nums[middle]

            when {
                item == target -> return middle
                target > item -> {
                    l = middle + 1
                }
                else -> {
                    r = middle - 1
                }
            }
        }

        return -1
    }
}

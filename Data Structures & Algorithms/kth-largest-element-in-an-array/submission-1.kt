class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        fun partition(start: Int, end: Int): Int {
            val pivot = nums[end]
            val target = nums.size - k

            var p = start
            for(i in start until end) {
                if(nums[i] <= pivot) {
                    nums[p] = nums[i].also {
                        nums[i] = nums[p]
                    }
                    p++
                } else {}
            }
            nums[p] = nums[end].also {nums[end] = nums[p]}

            return when {
                p > target -> partition(start, p - 1)
                p < target -> partition(p + 1, end)
                else -> nums[p]
            }
        }

        return partition(0, nums.size-1)
    }
}

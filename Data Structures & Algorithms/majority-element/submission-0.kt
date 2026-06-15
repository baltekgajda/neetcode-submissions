class Solution {
    fun majorityElement(nums: IntArray): Int {
        val hm = mutableMapOf<Int, Int>()
        for(n in nums) {
            hm[n] = (hm[n] ?: 0) + 1
            if(hm[n]!! > nums.size/2) {
                return n
            }
        }

        return -1
    }
}

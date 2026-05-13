class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val hm = TreeMap<Int, MutableSet<Int>>()
        for(i in 0 until k) {
            hm.getOrPut(nums[i]) { mutableSetOf()}.add(i)
        }

        val result = IntArray(nums.size-k+1)
        result[0] = hm.lastKey()

        for(i in 1 .. (nums.size - k)) {
            hm[nums[i-1]]?.remove(i-1)
            if(hm[nums[i-1]]?.isEmpty() == true) {
                hm.remove(nums[i-1])
            }

            hm.getOrPut(nums[i+k-1]) { mutableSetOf()}.add(i+k-1)
            result[i] = hm.lastKey()
        }

        return result
    }
}

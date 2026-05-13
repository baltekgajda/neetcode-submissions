class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val output = mutableListOf<Int>()
        val q = ArrayDeque<Int>()
        var l = 0
        var r = 0

        while (r < nums.size) {
            while(q.isNotEmpty() && nums[q.last()] < nums[r]) {
                q.removeLast()
            }

            q.addLast(r)

            if(l > q.first()) {
                q.removeFirst()
            }

            if(r+1 >= k) {
                output.add(nums[q.first()])
                l++
            }

            r++
        }

        return output.toIntArray()
    }
}

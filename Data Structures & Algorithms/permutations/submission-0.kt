class Solution {
    fun permute(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val current = mutableListOf<Int>()
        val used = mutableSetOf<Int>()

        fun perm() {
            if(current.size == nums.size) {
                result.add(current.toList())
                return 
            }

            for(i in nums.indices) {
                if(i in used) {
                    continue
                }

                used.add(i)
                current.add(nums[i])
                perm()
                current.removeLast()
                used.remove(i)
            }
        }

        perm()
        return result
    }
}

class Solution {
    fun hasDuplicate(nums: IntArray): Boolean {
        val dups = HashSet<Int>()
        for(i in nums) {
            if(i in dups) {
                return true
            }

            dups.add(i)
        }

        return false
    }
}

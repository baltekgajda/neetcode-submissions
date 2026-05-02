class Solution {
    fun hasDuplicate(nums: IntArray): Boolean {
        var dups = mutableMapOf<Int,Boolean>()
        for(i in nums) {
            if(dups.getOrDefault(i, false) == true) {
                return true
            } else {
                dups[i] = true
            }
        }

        return false
    }
}

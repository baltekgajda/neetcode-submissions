class Solution {
    fun singleNumber(nums: IntArray): Int {
        val set = HashSet<Int>()
        for(n in nums) {
            if(n in set) {
                set.remove(n)
            } else {
                set.add(n)
            }
        }

        return set.toList().get(0)
    }
}
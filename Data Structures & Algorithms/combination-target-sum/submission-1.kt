class Solution {
    fun combinationSum(nums: IntArray, target: Int): List<List<Int>> {
        val results = mutableListOf<List<Int>>()

        fun findCombinations(target: Int, numsToUse: List<Int>, current: List<Int>) {
            if(target < 0) {
                return
            }

            if(target == 0) {
                results.add(current)
                return
            }

            val num = numsToUse.getOrNull(0) ?: return
            val res = target - num
            findCombinations(res, numsToUse, current + num)
            findCombinations(target, numsToUse.drop(1), current)
        }

        findCombinations(target, nums.toList(), emptyList())
        return results
    }
}

class Solution {
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        candidates.sort()

        val result = mutableListOf<List<Int>>()
        fun findCandidates(index: Int, current: List<Int>, currentSum: Int) {
            if(currentSum > target) {
                return 
            }

            if(currentSum == target) {
                result.add(current.toList())
                return
            }

            if(index >= candidates.size) {
                return
            }

            findCandidates(index+1, current + candidates[index], currentSum + candidates[index])
            var i = index + 1
            while(i < candidates.size && candidates[i] == candidates[i-1]) {
                i++
            }
            findCandidates(i, current, currentSum)
        }

        findCandidates(0, emptyList(), 0)
        return result
    }
}

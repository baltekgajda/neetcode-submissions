class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val ar = IntArray(2001) {0}
        for(n in nums) {
            ar[n+1000]++
        }

        val result = ar.mapIndexed { index, value -> (index-1000) to value }.sortedByDescending {it.second}
        return result.take(k).map{it.first}.toIntArray()
    }
}

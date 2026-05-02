class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val remains = mutableMapOf<Int, Int>()
        for((i,v) in nums.withIndex()) {
            remains[target-v] = i
        }

        val result = IntArray(2) {0}
        for((i,v) in nums.withIndex()) {
            if(remains.containsKey(v) && remains[v] != i) {
                result[0] = i
                result[1] = remains[v]!!
                break
            }
        }

        return result
    }
}

class Solution {
    fun findTargetSumWays(nums: IntArray, target: Int): Int {
        val hm = mutableMapOf<Pair<Int,Int>,Int>()
        
        fun getSum(index: Int, currentSum: Int): Int {
            if(index == nums.size) {
                return if(currentSum == target) 1 else 0
            }

            if((index to currentSum) in hm) {
                return hm[index to currentSum]!!
            }

            val plusSum = getSum(index+1, currentSum + nums[index])
            val minusSum = getSum(index+1, currentSum - nums[index])
            hm[index to currentSum] = plusSum + minusSum
            return hm[index to currentSum]!!
        }

        return getSum(0, 0)
    }
}

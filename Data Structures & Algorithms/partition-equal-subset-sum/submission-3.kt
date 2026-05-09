class Solution {
    fun canPartition(nums: IntArray): Boolean {
        //0/1 subset sum DP problem WAZNE 0/1 Knapsack Pattern !!!!!!!!!!!!!!!!!
        // 1 we start from the end and create a set of all possible sums
        // for last element we can include it or not so {0, last_item}
        // for second to last we decide if we add it or now {0, last_item - not added, 0 + second_to_last, last + second_to_last}
        // we iterate until we find the solution
        val numsSum = nums.sum() % 2
        if(numsSum % 2 == 1) {
            return false
        }

        val target = nums.sum() / 2

        val sums = mutableSetOf(0, nums.last())
        for(i in nums.size-2 downTo 0) {
            val toAdd = mutableListOf<Int>()
            for(s in sums) {
                val result = s + nums[i]
                if(result == target) {
                    return true
                }
                toAdd.add(result)
            }
            sums.addAll(toAdd)
        }

        return false
    }
}

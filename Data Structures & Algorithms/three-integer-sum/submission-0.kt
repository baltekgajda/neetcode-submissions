class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        var previous = Int.MIN_VALUE
        var result = mutableListOf<List<Int>>()
        for((index, n) in nums.withIndex()) {
            if(previous == n) {
                continue
            }

            previous = n
            var i = index + 1
            var j = nums.size - 1
            while(i < j) {
                val res = n + nums[i] + nums[j]
                when {
                    res == 0 -> {
                        result.add(listOf(n, nums[i], nums[j]))
                        j--
                        i++
                        while(i < j && nums[i] == nums[i-1]) {
                            i++
                        }
                    }
                    res > 0 -> {
                        j--
                    }
                    res < 0 -> {
                        i++
                    }
                }
            }
        }

        return result
    }
}

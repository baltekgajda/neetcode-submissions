class Solution {
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        nums.sort()
        val result = mutableListOf<List<Int>>()
        for(i in 0 .. nums.size - 4) {
            if (i > 0 && nums[i] == nums[i - 1]) continue
            for(j in i + 1 .. nums.size - 3) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue
                val missing = target.toLong() - nums[i] - nums[j]
                var x = j + 1
                var y = nums.size - 1
                while (x < y) {
                    val xy = nums[x].toLong() + nums[y]
                    when {
                        xy == missing -> {
                            result.add(listOf(nums[i], nums[j], nums[x], nums[y]))
                            x++;y--
                            while (x < y && nums[x] == nums[x - 1]) x++
                            while (x < y && nums[y] == nums[y + 1]) y--
                        }
                        xy > missing -> y--
                        else -> x++
                    }
                }
            }
        }

        return result
    }
}

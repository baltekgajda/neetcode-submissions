class Solution {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        nums.sort()

        val result = mutableListOf<List<Int>>()
        val current = mutableListOf<Int>()
        fun getSubset(index: Int) {
            if(index >= nums.size) {
                result.add(current.toList())
                return
            }

            current.add(nums[index])
            getSubset(index+1)
            current.removeLast()

            var j = 1
            while(index + j < nums.size && nums[index] == nums[index + j]){
                j++
            }

            getSubset(index+j)
        }

        getSubset(0)
        return result
    }
}

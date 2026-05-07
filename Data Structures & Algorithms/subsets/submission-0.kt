class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
        
        fun getSubsets(startIndex: Int):List<List<Int>> {
            if(startIndex == nums.size) {
                return listOf(mutableListOf())
            }

            //not included
            val notIncludedSubsets = getSubsets(startIndex + 1)

            //included 
            val includedSubsets = notIncludedSubsets.map { it + nums[startIndex] }
            return notIncludedSubsets + includedSubsets
        }

        return getSubsets(0)
    }
}

class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val hm = nums.toSet().associateWith {-1}.toMutableMap()
        var longest = 0

        if(nums.isEmpty())
            return 0
        
        fun getFollowingNumbers(n: Int): Int {
            val fol = hm[n]
            if(fol != -1) {
                return fol!!
            }

            if(hm.containsKey(n+1)) {
                hm[n] = 1 + getFollowingNumbers(n+1)
                if(hm[n]!! > longest) {
                    longest = hm[n]!!
                }
                return hm[n]!!
            } else {
                hm[n] = 0
                return 0
            }
        }

        for(n in nums) {
            hm[n] = getFollowingNumbers(n)
        }

        return longest+1
    }
}

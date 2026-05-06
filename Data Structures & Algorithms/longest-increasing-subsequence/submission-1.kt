class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        var longest = 0
        var result = 0
        val memo = IntArray(nums.size+1) {Int.MIN_VALUE}
            
        for((i,n) in nums.withIndex()) {
            if(n > memo[longest]) {
                longest++
                result = max(result, longest)
                memo[longest] = n
                continue
            }

            if(n == memo[longest]) {
                continue
            }

            var j = longest - 1
            while(n < memo[j]) {
                j--
            }

            if(n == memo[j]) {
                continue
            }

            memo[j+1] = n
        }

        return result
    }
}

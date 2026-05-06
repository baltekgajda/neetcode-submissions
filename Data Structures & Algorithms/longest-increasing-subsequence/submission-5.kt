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

// we iterate thouugh nums and check longest list while currently traversing
// we check whether we can add to longest (eg.3) if now, we check if we could add to two and so on
// when we find the place we update it as it will be smaller then what was there before so it is easier to add sth
// for current position everything stored in memo holds longest paths we could get of length 4,3,2 and last item and we add to the longest

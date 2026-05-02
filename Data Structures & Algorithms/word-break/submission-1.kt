class Solution {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val dp = BooleanArray(s.length+1)
        dp[s.length] =  true

        for (i in s.length-1 downTo 0) {
            for(w in wordDict) {
                if(i + w.length <= s.length && s.substring(i, i+w.length) == w) {
                    dp[i] = dp[i+w.length]
                }
                if(dp[i] == true) {
                    break
                }
            }
        }

        return dp[0]
    }
}
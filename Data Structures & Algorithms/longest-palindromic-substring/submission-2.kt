class Solution {
    val memo = mutableMapOf<String, Boolean>()
    var longest = ""
    fun isPalindrome(s: String): Boolean {
        if(s.length <= 1) {
            if(s.length > longest.length) {
                longest = s
            }
            return true
        }

        if(s in memo) {
            return memo[s]!!
        }

        val start = 0
        val end = s.length - 1

        if(s[0] != s[s.length-1]) {
            memo[s] = false
            return false
        }

        if(s.length == 2 || s.length == 3) {
            memo[s] = true
            if(s.length > longest.length) {
                longest = s
            }
            return true
        }

        val result = isPalindrome(s.substring(1, s.length-1))
        memo[s] = result
        if(result && s.length > longest.length) {
            longest = s
        }
        return result
    }

    fun longestPalindrome(s: String): String {
        for(i in s.length downTo 1) {
            for(j in 0 until s.length-i+1) {
                isPalindrome(s.substring(j, j+i))
            }
        }
        return longest
    }
}

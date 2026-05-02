class Solution {
    fun countSubstrings(s: String): Int {
        var count = 0

        fun checkPalindrome(start: Int, end: Int) {
            if(start <0 || end == s.length) {
                return
            }

            if(s[start] == s[end]) {
                count++
                checkPalindrome(start-1, end+1)
            }
        }

        for(i in 0 until s.length) {
            count++
            checkPalindrome(i-1, i+1)
        }

        for(i in 0 until s.length-1) {
            if(s[i] == s[i+1]) {
                count++
                checkPalindrome(i-1, i+2)
            }
        }

        return count
    }
}
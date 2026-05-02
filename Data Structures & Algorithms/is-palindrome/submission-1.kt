class Solution {
    fun isPalindrome(s: String): Boolean {
        var i = 0
        var j = s.length - 1

        if (s.length == 1) {
            return true
        }

        while (i < j) {
            val iChar = s[i].lowercaseChar()
            val jChar = s[j].lowercaseChar()

            if(!iChar.isLetterOrDigit()) {
                i++
                continue
            }

            if(!jChar.isLetterOrDigit()) {
                j--
                continue
            }

            if(iChar != jChar) {
                return false
            }

            i++
            j--
        }

        return true
    }
}

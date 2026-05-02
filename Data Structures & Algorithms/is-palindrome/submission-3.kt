class Solution {
    fun isPalindrome(s: String): Boolean {
        var alphaNumS = ""
        for (c in s) {
            if (c.isLetterOrDigit()) {
                alphaNumS += c.lowercaseChar()
            }
        }

        return alphaNumS == alphaNumS.reversed()
    }
}

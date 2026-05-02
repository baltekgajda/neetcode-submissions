class Solution {
    fun isPalindrome(s: String): Boolean {
        val alphaNumS = s
        .filter { it.isLetterOrDigit()}
        .map { it.lowercase() }

        return alphaNumS == alphaNumS.reversed()
    }
}

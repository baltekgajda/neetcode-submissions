class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        val letters = ('a' .. 'z').associateWith {0}.toMutableMap()
        for(c in s) {
            letters[c] = letters.getOrDefault(c, 0) + 1
        }

        for(c in t) {
            letters[c] = letters.getOrDefault(c, 0) - 1
        }

        for(i in letters.values) {
            if(i != 0) {
                return false
            }
        }

        return true
    }
}

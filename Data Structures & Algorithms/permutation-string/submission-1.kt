class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        if(s2.length < s1.length) {
            return false
        }

        val freq = Array<Int>(26) { 0 }
        var s2Freq = Array<Int>(26) { 0 }
        val letters = mutableSetOf<Char>()
        var missingLetters = mutableSetOf<Char>()
        var currentSubstring = mutableListOf<Char>()

        for(c in s1) {
            freq[c-'a'] = freq[c-'a'] + 1
            letters.add(c)
            missingLetters.add(c)
        }

        for((i, c) in s2.withIndex()) {
            if(c !in missingLetters && c !in letters) {
                s2Freq = Array<Int>(26) { 0 }
                missingLetters = letters.toMutableSet()
                currentSubstring = mutableListOf()
                continue
            }

            // present in letters
            while(c !in missingLetters) {
                val firstChar = currentSubstring.removeFirst()
                s2Freq[firstChar-'a']-=1
                if(s2Freq[firstChar-'a'] < freq[firstChar-'a']) {
                    missingLetters.add(firstChar)
                }
            }

            // present in missing letters
            currentSubstring.add(c)
            s2Freq[c-'a']+= 1

            if(s2Freq[c-'a'] == freq[c-'a']) {
                missingLetters.remove(c)
            }

            if(missingLetters.isEmpty()) {
                return true
            }
        }

        return false
    }
}



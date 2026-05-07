class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        if(s1.length > s2.length) {
            return false
        }

        val freq = IntArray(26) {0}
        val currentFreq = IntArray(26) {0}
        var matches = 0

        for(c in s1) {
            freq[c-'a']+=1
        }

        for(i in 0 until s1.length) {
            currentFreq[s2[i]-'a']+=1
            if(currentFreq[s2[i]-'a'] <= freq[s2[i]-'a']) {
                matches++
            }
        }

        if(matches == s1.length) {
            return true
        }

        for(i in 1 .. s2.length-s1.length) {
            currentFreq[s2[i-1]-'a']--
            if(currentFreq[s2[i-1]-'a'] < freq[s2[i-1]-'a']) {
                matches--
            }

            currentFreq[s2[i+s1.length-1]-'a']+=1
            if(currentFreq[s2[i+s1.length-1]-'a'] <= freq[s2[i+s1.length-1]-'a']) {
                matches++
            }

            if(matches == s1.length) {
                return true
            }
        }

        return false
    }
}



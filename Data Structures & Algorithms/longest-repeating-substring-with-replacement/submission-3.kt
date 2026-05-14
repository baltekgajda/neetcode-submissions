class Solution {
    fun characterReplacement(s: String, k: Int): Int {
            var startIndex = 0
            var mostPopularCharCount = 0
            val freq = mutableMapOf<Char, Int>()
            var result = 0

            for(i in 0 until s.length) {
                freq[s[i]] = (freq[s[i]] ?: 0) + 1
                mostPopularCharCount = max(mostPopularCharCount, freq[s[i]]!!)

                while(i-startIndex+1-mostPopularCharCount > k) {
                    freq[s[startIndex]] = freq[s[startIndex]]!! - 1
                    //we only shrink the window, we don't have proper result here
                    startIndex++
                }

                result = max(result, i-startIndex+1)
            }
        return result
    }
}
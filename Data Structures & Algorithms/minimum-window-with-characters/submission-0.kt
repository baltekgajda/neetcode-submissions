class Solution {
    fun minWindow(s: String, t: String): String {
        val freq = mutableMapOf<Char, Int>()
        val currentFreq = mutableMapOf<Char, Int>()
        val charsMissing = mutableSetOf<Char>()
        var result = Int.MAX_VALUE
        var resultIndices = 0 to 0

        for(c in t) {
            freq[c] = (freq[c] ?: 0) + 1
            charsMissing.add(c)
        }

        val substring = mutableListOf<Pair<Int, Char>>()

        for((i, c) in s.withIndex()) {
            if(c in freq) {
                substring.add(i to c)
                currentFreq[c] = (currentFreq[c] ?: 0) + 1
            }

            if(c !in charsMissing) {
                continue
            }

            if((currentFreq[c] ?: 0) >= freq[c]!!) {
                charsMissing.remove(c)
            }

            while(charsMissing.isEmpty()) {
                val length = substring.last().first - substring.first().first
                if(length < result) {
                    result = length
                    resultIndices = substring.first().first to substring.last().first
                }

                val removedChar = substring.removeFirst().second
                currentFreq[removedChar] = (currentFreq[removedChar] ?: 0) - 1
                if (currentFreq[removedChar]!! < freq[removedChar]!!) {
                    charsMissing.add(removedChar)
                }
            }
        }

        return if(result == Int.MAX_VALUE) {
            ""
        } else {
            s.substring(resultIndices.first, resultIndices.second+1)
        }
    }
}

// 1. first for string t we calculate how many duplicate each letter has and we store it in the ma
// 2. we also keep a set of letters we still need to have the complete substring
// 2a. we keep a map of which is a map of frequency of each letter, we add to it if we have a new letter
// 3. we also keep a mutable list of chars with indices that we have in current substring (we will be remove first from this list)
// 4. we iterate over the the string s and for each char we check whether we need it == if it is in set
// 5. we append it to out list to the end and we add it to our map, we check if frequency in map is the same as in t, if so, we remove this character
//    from letters we need
// 6. if set of characters to visit is empty, we calculate its size and update min substring
// 7. we remove the first character from mutable list, we update the set of used chars, map of duplicates and traverse till the end
// 8. we return the result.
// - time complexity O(N)
// - space complexity O()

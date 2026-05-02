class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val chars = IntArray(128) {-1}
        var longest = 0
        var begIndex = 0
        for((i,c) in s.withIndex()) {
            val index = c.code
            val cIndex = chars[index]
            if(cIndex == -1) {
                chars[index] = i
                val len = i-begIndex + 1
                if(len > longest) {
                    longest = len
                }
            } else {
                for(i2 in begIndex .. cIndex) {
                    chars[s[i2].code] = -1
                }
                chars[index] = i
                begIndex = cIndex+1
            }
        }

        return longest
    }
}

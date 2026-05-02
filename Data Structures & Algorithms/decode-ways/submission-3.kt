class Solution {
    fun numDecodings(s: String): Int {
        var prev1 = 1
        var prev2 = 1
        for(i in s.length-1 downTo 0) {
            val current = prev1
            if(s[i] == '0') {
                prev2 = prev1
                prev1 = 0
                continue
            }

            val temp = prev2
            prev2 = prev1
            prev1 = current
            val nextNumber = s.getOrNull(i+1) ?: continue
            val twoNumbers = "" + s[i] + nextNumber
            if(twoNumbers.length == 2 && twoNumbers.toInt() <= 26) {
                prev1 = prev1 + temp
            }
        }

        return prev1
    }
}
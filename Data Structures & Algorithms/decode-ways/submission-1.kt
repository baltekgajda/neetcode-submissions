class Solution {
    fun numDecodings(s: String): Int {
        val ar = IntArray(s.length+2) {1}
        for(i in s.length-1 downTo 0) {
            val current = ar.getOrElse(i+1) {1}
            if(s[i] == '0') {
                ar[i] = 0
                continue
            }

            ar[i] = current
            val nextNumber = s.getOrNull(i+1) ?: continue
            val twoNumbers = "" + s[i] + nextNumber
            if(twoNumbers.length == 2 && twoNumbers.toInt() <= 26) {
                ar[i] = ar[i] + ar.getOrElse(i+2) {1}
            }
        }

        return ar[0]
    }
}
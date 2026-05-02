class Solution {
    fun reverseBits(n: Int): Int {
        var result = 0
        for (i in 0 until 32) {
            val bit = n shr i and 1 // get bit
            result = result or (bit shl (31-i))
        }

        return result
    }
}

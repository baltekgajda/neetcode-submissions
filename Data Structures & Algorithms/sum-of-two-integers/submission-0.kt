class Solution {
    fun getSum(a: Int, b: Int): Int {
        val mask = 0xFFFFFFFF.toInt()
        val maxInt = 0x7FFFFFF.toInt()

        var first = a
        var carry = b

        while (carry != 0) {
            val tempCarry = (first and carry) shl 1
            first = first xor carry
            carry = tempCarry
        }

        return first
    }
}

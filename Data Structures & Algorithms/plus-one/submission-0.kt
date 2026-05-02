class Solution {
    fun plusOne(digits: IntArray): IntArray {
        var increment = 1
        for(i in digits.size - 1 downTo 0) {
            digits[i] = digits[i] + increment
            increment = digits[i]/10
            digits[i] = digits[i] % 10
        }

        return if(increment == 1) {
            intArrayOf(1) + digits
        } else {
            digits
        }
    }
}

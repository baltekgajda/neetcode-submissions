class Solution {
    fun isHappy(n: Int): Boolean {
        var fast = sumOfSquares(n)
        var slow = n

        while(slow != fast) {
            slow = sumOfSquares(slow)
            fast = sumOfSquares(fast)
            fast = sumOfSquares(fast)
        }

        return fast == 1
    }

    fun sumOfSquares(n: Int): Int {
        var num = n
        var result = 0
        while(num >= 10) {
            val remain = num % 10
            result += remain*remain
            num /= 10
        }
        result += num*num
        return result
    }
}

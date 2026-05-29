class Solution {
    fun myPow(x: Double, n: Int): Double {
        return when {
            x == 0.0 -> 0.0
            n == 0 -> 1.0
            n == 1 -> x
            n < 0 -> 1/myPow(x, -1*n)
            else -> {
                val half = myPow(x, n/2)
                if(n % 2 == 0) {
                    half * half
                } else {
                    x * half * half
                }
            }
        }
    }
}

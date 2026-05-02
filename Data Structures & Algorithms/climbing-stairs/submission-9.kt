class Solution {
    fun climbStairs(n: Int): Int {
        var oneBefore = 2
        var twoBefore = 1
        
        if(n <= 2) {
            return n
        }

        for(i in 3..n) {
            val temp = oneBefore
            oneBefore = oneBefore + twoBefore
            twoBefore = temp

            println(oneBefore)
            println(twoBefore)
        }

        return oneBefore
    }
}

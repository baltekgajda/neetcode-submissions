class Solution {
    
    fun climbStairs(n: Int): Int {
        val array = IntArray(n+3)
        array[0] = 0
        array[1] = 1
        array[2] = 2

        for(i in 3 .. n) {
            array[i] = array[i-1] + array[i-2]
        }

        return array[n]
    }
}

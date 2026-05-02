class Solution {
    fun countBits(n: Int): IntArray {
        val result = IntArray(n+1)
        for(i in 0..n) {
            var one = 0
            for(b in 0 until 32) {
                if(i shr b and 1 == 1) {
                    one++
                }
            }
            result[i] = one
        }
        return result
    }
}




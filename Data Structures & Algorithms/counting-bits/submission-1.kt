class Solution {
    fun countBits(n: Int): IntArray {
        if(n == 0) {
            return intArrayOf(0)
        }

        val result = mutableListOf(0)

        while(true) {
            for(i in 0 until result.size) {
                result.add(result[i]+1)
                if(result.size == n + 1) {
                    return result.toIntArray()
                }
            }
        }
    }
}




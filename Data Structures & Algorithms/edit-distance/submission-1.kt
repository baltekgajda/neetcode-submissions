class Solution {
    fun minDistance(word1: String, word2: String): Int {

        val memo = mutableMapOf<Pair<Int,Int>, Int>()

        fun checkChar(index1: Int, index2: Int): Int {
            if((index1 to index2) in memo) {
                return memo[index1 to index2]!!
            }

            if(index2 == word2.length) {
                return if(index1 == word1.length) {
                    0
                } else {
                    kotlin.math.abs(word1.length - index1)
                }
            }

            if(index1 == word1.length) {
                return kotlin.math.abs(word2.length - index2)
            }

            if(word1[index1] == word2[index2]) {
                return checkChar(index1+1, index2+1)
            }

            val remove = 1 + checkChar(index1+1, index2)
            val switch = 1 + checkChar(index1+1, index2+1)
            val add = 1 + checkChar(index1, index2+1)

            val result = listOf(remove, switch, add).min()
            memo[index1 to index2] = result
            return result
        }

        return checkChar(0, 0)
    }
}
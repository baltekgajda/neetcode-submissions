class Solution {
    fun minDistance(word1: String, word2: String): Int {

        val memo = mutableMapOf<Pair<Int,Int>, Int>()

        fun checkChar(index1: Int, index2: Int): Int {
            val key = index1 to index2
            if(key in memo) {
                return memo[key]!!
            }
            
            val result = when {
                index1 == word1.length -> word2.length - index2
                index2 == word2.length -> word1.length - index1
                word1[index1] == word2[index2] -> checkChar(index1+1, index2+1)
                else -> 1 + minOf(
                    checkChar(index1+1, index2), //remove
                    checkChar(index1+1, index2+1), //switch
                    checkChar(index1, index2+1) //add
                )
            }

            memo[key] = result
            return result
        }

        return checkChar(0, 0)
    }
}
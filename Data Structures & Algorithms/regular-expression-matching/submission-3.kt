class Solution {
    fun isMatch(s: String, p: String): Boolean {

        val memo = mutableMapOf<Pair<Int,Int>, Boolean>()

        fun checkAtIndex(sIndex: Int, pIndex: Int): Boolean {
            if((sIndex to pIndex) in memo) {
                return memo[sIndex to pIndex]!!
            }

            val result = when {
                pIndex < 0 && sIndex >= 0 -> false
                sIndex < 0 -> {
                    when {
                        pIndex < 0 -> true
                        p[pIndex] != '*' -> false
                        else -> checkAtIndex(sIndex, pIndex-2)
                    }
                }
                p[pIndex] == '.' -> checkAtIndex(sIndex-1, pIndex - 1)
                p[pIndex] != '*' -> s[sIndex] == p[pIndex] && checkAtIndex(sIndex-1, pIndex - 1)
                else -> checkAtIndex(sIndex, pIndex-2) || ((s[sIndex] == p[pIndex-1] || p[pIndex-1] == '.') && checkAtIndex(sIndex-1, pIndex))
            }

            memo[sIndex to pIndex] = result
            return result
        }

        return checkAtIndex(s.length-1, p.length-1)
    }
}

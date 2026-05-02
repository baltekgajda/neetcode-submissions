class Solution {
    fun hammingWeight(n: Int): Int {
        var result = 0
        for(i in 0 until 32) {
            result += (n shr i and 1)
        }

        return result
    }
}

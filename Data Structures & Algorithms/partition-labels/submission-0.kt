class Solution {
    fun partitionLabels(s: String): List<Int> {
        //interate over string and save first and last occurance of each letter
        val letters = Array<IntArray>(26) { IntArray(2) { -1 }}
        val result = mutableListOf<Int>()
        for((index, c) in s.withIndex()) {
            val i = c - 'a'
            if(letters[i][0] == -1) {
                letters[i][0] = index
            }

            letters[i][1] = index
        }

        var start = 0
        var end = 0 // end included
        for((index, c) in s.withIndex()) {
            val i = c - 'a'
            if(letters[i][1] > end ) {
                end = letters[i][1]
            }

            if(index == end) {
                result.add(end-start+1)
                start = index+1
                end = index+1
                continue
            }
        }

        return result
    }
}

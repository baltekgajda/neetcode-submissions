class Solution {
    fun isAlienSorted(words: Array<String>, order: String): Boolean {
        val ordered = IntArray(order.length) {0}

        for(i in 0 until order.length) {
            ordered[order[i] - 'a'] = i
        }

        for(i in 1 until words.size) {
            var j = 0
            while(j < words[i-1].length && j < words[i].length) {
                if(words[i-1][j] == words[i][j]) {
                    j++
                    continue
                } else if(ordered[words[i-1][j] - 'a'] > ordered[words[i][j] - 'a']) {
                    return false
                } else {
                    break
                }
            }

            if(j == words[i-1].length || j == words[i].length) {
                if(words[i-1].length > words[i].length)
                    return false
            }
        }

        return true
    }
}

class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        if(s.length == 1) {
            return 1
        }

        val countMap = mutableMapOf<Char, Int>()
        var maxF = 0
        var result = 0
        var startIndex = 0
        for(i in s.indices) {
            countMap[s[i]] = countMap.getOrElse(s[i]) {0} + 1
            maxF = max(maxF, countMap[s[i]]!!)
            
            while(i-startIndex+1-maxF > k) {
                countMap[s[startIndex]] = countMap[s[startIndex]]!! - 1
                startIndex++
            }

            result = max(result, i-startIndex+1)
        }    

        return result
    }
}
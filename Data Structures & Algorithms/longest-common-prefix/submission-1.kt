class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        val result = mutableListOf<Char>()
        if(strs.size == 1) {
            return strs[0]
        }

        for(i in 0 until strs[0].length) {
            for(j in 1 until strs.size) {
                if(strs[j].length <= i || strs[j][i] != strs[0][i]) {
                    return result.joinToString("")
                }
            }

            result.add(strs[0][i])
        }

        return result.joinToString("")
    }
}

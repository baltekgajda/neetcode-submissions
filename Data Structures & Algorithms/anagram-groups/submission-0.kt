class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val result = mutableMapOf<List<Int>, MutableList<String>>()
        for(str in strs) {
            val alphabetArray = buildAlphabetArray(str)
            result.getOrPut(alphabetArray) { mutableListOf() }.add(str)
        }

        return result.values.toList()
    }

    fun buildAlphabetArray(str: String): List<Int> {
        val letters = ('a'..'z').associateWith {0}.toMutableMap()
        for(c in str) {
            letters[c] = letters.getOrDefault(c, 0) + 1
        }

        return letters.values.toList()
    }
}

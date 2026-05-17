class Solution {
    fun partition(s: String): List<List<String>> {
        val result = mutableListOf<List<String>>()
        val currentSubstring = mutableListOf<String>()

        //start and end included
        fun isPalindrome(word: String): Boolean {
            var i = 0
            var j = word.length - 1
            while (i < j) {
                if(word[i] != word[j]) {
                    return false
                }
                i++
                j--
            }

            return true
        }

        fun getPalindrome(start: Int, current: Int) {
            if(start == s.length) {
                result.add(currentSubstring.toList())
                return
            }

            if(current == s.length) {
                return
            }

            val word = s.substring(start, current+1)
            if(isPalindrome(word)) {
                currentSubstring.add(word)
                getPalindrome(current + 1, current + 1)
                currentSubstring.removeLast()
            }

            getPalindrome(start, current + 1)
        }

        getPalindrome(0, 0)

        return result
    }
}

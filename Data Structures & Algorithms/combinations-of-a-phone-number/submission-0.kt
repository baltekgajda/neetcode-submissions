class Solution {
    fun letterCombinations(digits: String): List<String> {
        if(digits.length == 0) {
            return emptyList()
        }
        
        val map = mutableMapOf(
            2 to listOf('a', 'b', 'c'),
            3 to listOf('d', 'e', 'f'),
            4 to listOf('g', 'h', 'i'),
            5 to listOf('j', 'k', 'l'),
            6 to listOf('m', 'n', 'o'),
            7 to listOf('p', 'q', 'r', 's'),
            8 to listOf('t', 'u', 'v'),
            9 to listOf('w', 'x', 'y', 'z')
        )

        val result = mutableListOf<String>()
        var current = mutableListOf<Char>()

        fun goDigit(index: Int) {
            if(index == digits.length) {
                result.add(current.joinToString(""))
                return
            }

            val digit = digits[index].digitToInt()
            for(c in map[digit]!!) {
                current.add(c)
                goDigit(index+1)
                current.removeLast()
            }
        }

        goDigit(0)
        return result
    }
}

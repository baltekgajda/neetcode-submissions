class Solution {
    fun generateParenthesis(n: Int): List<String> {

        var result = mutableListOf<String>()
        val current = mutableListOf<Char>()
        fun getOneResult(opening: Int, closing: Int) {
            if(opening == n && closing == n) {
                result.add(current.joinToString(""))
                return
            }

            if(opening > n) {
                return
            }

            if(closing > opening) {
                return
            }

            current.add('(')
            getOneResult(opening + 1, closing)
            current.removeLast()
            current.add(')')
            getOneResult(opening, closing + 1)
            current.removeLast()
        }

        getOneResult(0, 0)
        return result
    }
}

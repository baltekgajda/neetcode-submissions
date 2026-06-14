class Solution {
    fun addBinary(a: String, b: String): String {
        val aRev = a.reversed()
        val bRev = b.reversed()

        var addOne = 0
        val result = mutableListOf<Int>()
        for(i in 0 until maxOf(a.length, b.length)) {
            val ac = aRev.getOrNull(i)?.digitToInt() ?: 0
            val bc = bRev.getOrNull(i)?.digitToInt() ?: 0
            
            val new = ac + bc + addOne
            if(new > 1) {
                result.add(new % 2)
                addOne = 1
            } else {
                result.add(new)
                addOne = 0
            }
        }

        if(addOne == 1) {
            result.add(addOne)
        }

        return result.reversed().map { if(it == 0) '0' else '1'}.joinToString("")
    }
}

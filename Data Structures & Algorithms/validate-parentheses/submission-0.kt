class Solution {
    fun isValid(s: String): Boolean {
        if (s.length % 2 != 0) {
            return false
        }

        val stack = mutableListOf<Char>()
        for (c in s) {
            if (c in setOf('[', '(', '{')) {
                stack.add(c)
            } else {
                val opposite = getOppositeChar(c) ?: return false
                val last = stack.lastOrNull() ?: return false
                if (opposite != last) {
                    return false
                }
                stack.removeLast()
            }
        }
        
        return stack.isEmpty()
    }

    private fun getOppositeChar(c: Char): Char? {
        return when(c) {
            ']' -> '['
            '}' -> '{'
            ')' -> '('
            else -> null
        }
    }
}


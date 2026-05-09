class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = ArrayDeque<String>()
        val operators = setOf("+", "-", "*", "/")

        for(token in tokens) {
            if(token !in operators) {
                stack.add(token)
            } else {
                val second = stack.removeLast().toInt()
                val first = stack.removeLast().toInt()
                val result = when(token) {
                "+" -> first + second
                "-" -> first - second
                "*" -> first * second
                "/" -> first / second
                else -> 0
                }
                stack.add(result.toString())
            }
        }

        return stack.first().toInt()
    }
}

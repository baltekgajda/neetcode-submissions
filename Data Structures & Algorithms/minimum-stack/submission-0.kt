class MinStack() {

    val stack = ArrayDeque<Pair<Int,Int>>()

    fun push(`val`: Int) {
        if(stack.isEmpty()) {
            stack.addLast(`val` to `val`)
        } else {
            val currentMin = getMin()
            if(`val` < currentMin) {
                stack.addLast(`val` to `val`)
            } else {
                stack.addLast(`val` to currentMin)
            }
        }
    }

    fun pop() {
        stack.removeLast()
    }

    fun top(): Int {
        return stack.last().first
    }

    fun getMin(): Int {
        return stack.last().second
    }
}

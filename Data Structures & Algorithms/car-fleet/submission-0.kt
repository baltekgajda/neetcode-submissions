class Solution {
    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
        val sortList = position.zip(speed).sortedByDescending { it.first }
        val stack = mutableListOf<Double>()

        for((p, s) in sortList) {
            val time = (target-p).toDouble() / s
            stack.add(time)
            if(stack.size >= 2 && stack[stack.size - 1] <= stack[stack.size - 2]) {
                stack.removeLast()
            }
        }

        return stack.size
    }
}

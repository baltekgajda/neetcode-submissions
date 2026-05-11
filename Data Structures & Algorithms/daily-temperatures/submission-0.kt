class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val result = IntArray(temperatures.size) { 0 }
        val stack = ArrayDeque<Pair<Int, Int>>() //first is temperature, second is index of this temperature

        stack.addLast(temperatures[0] to 0)
        for(i in 1 until temperatures.size) {
            var last = stack.lastOrNull()
            while(last != null && last.first < temperatures[i]) {
                stack.removeLast()
                result[last.second] = i - last.second
                last = stack.lastOrNull()
            }

            stack.addLast(temperatures[i] to i)
        }

        return result
    }
}

// 1. we create a stack that on top will be the last visited temperature with index of it
// 2. we traverse the list. we check first item on the stack and if the value there is smaller, we update value at stack as result
//     and we repeat that until we find the larger item which we don't remove and we add new value to the stack
// 3. doing so we create a stack that has the smallest value first then larger ones

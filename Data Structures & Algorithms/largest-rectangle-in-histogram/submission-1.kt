class Solution {
    fun largestRectangleArea(heights: IntArray): Int {
        // pair of start index to height
        val stack = ArrayDeque<Pair<Int, Int>>()

        var maxRect = 0
        for(i in 0 until heights.size) {
            val h = heights[i]
            var top = stack.lastOrNull()
            if(top == null) {
                stack.add(i to h)
                continue
            }

            when {
                h > top?.second!! -> {
                    stack.add(i to h)
                }
                else -> {
                    var j = i
                    while(top != null && h <= top?.second!!) {
                        stack.removeLast()
                        j = top?.first!!
                        maxRect = max(maxRect, (i-top?.first!!) * top?.second!!)
                        top = stack.lastOrNull()
                    }
                    stack.add(j to h)
                }
            }
        }

        while(stack.isNotEmpty()) {
            val top = stack.removeLast()
            maxRect = max(maxRect, (heights.size-top?.first!!) * top?.second!!)
        }

        return maxRect
    }
}

// 1. we create a stack that holds height of a bar and index of first element that has the same height we can extend
// 2. we iterate over heights. if height is larger then top of stack, we add it to stack with index of the bar as that is the max
// 3. if there is a bar the same height, we remove last and don't add anything  (we already have a start index from previous)
// 4. if the bar is lower then previous, we will remove top of stack until top of stack is lower or equal = if equal we move on
// 5. before we remove the bar we calcaulate max rectange size using index saved in queue and current index to calculate the rectangle size
// 6. we iterate over the entire array and return maxRectangle

class Solution {
    fun maxArea(heights: IntArray): Int {
        var i = 0
        var j = heights.size - 1
        var maximum = 0
        while(i < j) {
            val water = (j-i)*min(heights[i], heights[j])
            if(water > maximum) {
                maximum = water
            }

            if(heights[i] <= heights[j]) {
                i++
            } else {
                j--
            }
        }

        return maximum
    }
}

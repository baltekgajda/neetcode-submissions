class Solution {
    fun trap(height: IntArray): Int {
        if(height.size < 3) {
            return 0
        }

        var beg: Int? = null
        for((i, v) in height.withIndex()) {
            if(v > 0) {
                beg = i
                break
            }
        }

        // return index of end or null if doesnt find
        fun findEnd(start: Int): Int? {
            var currentHeighest = 0
            var currentHeighestIndex = -1
            for(i in start+1 until height.size) {
                if(height[i] >= height[start]) {
                    return i
                }

                if(height[i] > currentHeighest) {
                    currentHeighest = height[i]
                    currentHeighestIndex = i
                }
            }

            return if(currentHeighestIndex != -1) {
                currentHeighestIndex
            } else {
                null
            }
        }

        var maxWater = 0
        beg ?: return 0

        while(beg != null) {
            val end = findEnd(beg) ?: return maxWater
            val definedHeight = min(height[beg], height[end])
            var water = 0
            for(i in beg+1 until end) {
                water += definedHeight - height[i]
            }
            maxWater += water
            beg = end
        }

        return maxWater
    }
}

// 1. first we find first height > 0 and we save it as out first-bar
// 2. we iterate over next bars looking for a higher or the same bar height bar 
//     if there is no, we try to find the highest there is
// 3. knowing our height we iterate over bars until we meet our other end and we calculate water
// 4. we set the second highest as our first and we repeat the process until we reach the end

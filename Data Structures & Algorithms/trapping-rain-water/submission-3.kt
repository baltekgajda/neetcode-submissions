class Solution {
    fun trap(height: IntArray): Int {

        //REMEMBER THAT AMOUNT OF WATER AT INDEX IS MIN(MAX TO LEFT, MAX TO RIGHT) - HEIGHT AT INDEX
        if(height.size < 3) {
            return 0
        }

        var maxLeftWater = height[0]
        var maxRightWater = height[height.size-1]
        var maxWater = 0

        var (start, end) = if(maxLeftWater <= maxRightWater) {
            1 to height.size-1
        } else {
            0 to height.size-2
        }

        while (start < end) {
            if(maxLeftWater <= maxRightWater) {
                //update start
                val water = max(maxLeftWater - height[start], 0)
                maxWater += water
                maxLeftWater = max(height[start], maxLeftWater)
            } else {
                //update end
                val water = max(maxRightWater - height[end], 0)
                maxWater += water
                maxRightWater = max(height[end], maxRightWater)
            }

            if(maxLeftWater <= maxRightWater) {
                start++
            } else {
                end--
            }
        }

        return maxWater
    }
}
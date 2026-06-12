class Solution {
    fun shipWithinDays(weights: IntArray, days: Int): Int {
        fun checkDays(maxW: Int): Int {
            var result = 0
            var currentWeight = 0
            for(w in weights) {
                currentWeight += w
                if(currentWeight > maxW) {
                    result++
                    currentWeight = w
                }
            }

            if(currentWeight > 0) {
                result++
            }

            return result
        }

        var l = weights.max()
        var r = weights.sum()
        while (l<=r) {
            val middle = (l+r)/2
            val middleDays = checkDays(middle)
            if(middleDays <= days) {
                r = middle - 1
            } else {
                l = middle + 1
            }
        }

        return l
    }
}

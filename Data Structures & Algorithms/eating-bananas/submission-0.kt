class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {

        //end excluded
        var result = Int.MAX_VALUE
        fun binarySearch(start: Int, end: Int) {
            if (start >= end) return

            val middle = (end-start)/2 + start

            var current = 0
            for(p in piles) {
                current += kotlin.math.ceil(p/middle.toDouble()).toInt()
            }

            if(current > h) {
                binarySearch(middle+1, end)
            } else {
                result = min(result, middle)
                binarySearch(start, middle)
            }
        }

        binarySearch(1, piles.max() + 1)
        return result
    }
}

// 1. max result would be the largest pile
// 2. we check results from 0 to largest pile but with binary search to not check each result

class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        val maxPile = piles.max()
        var result = maxPile

        var l = 1
        var r = maxPile
        while(l<=r) {
            val middle = (l+r)/2

            var current = 0
            for(p in piles) {
                current+= kotlin.math.ceil(p/middle.toDouble()).toInt()
            }

            if(current > h) {
                l = middle + 1
            } else {
                r = middle - 1
                if(middle < result) {
                    result = middle
                }
            }
        }

        return result
    }
}


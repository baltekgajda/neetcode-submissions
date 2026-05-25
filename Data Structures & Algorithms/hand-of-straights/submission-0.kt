class Solution {
    fun isNStraightHand(hand: IntArray, groupSize: Int): Boolean {
        if(hand.size % groupSize != 0) {
            return false
        }

        val map = TreeMap<Int, Int>()
        for(h in hand) {
            map[h] = (map[h] ?: 0) + 1
        }

        while(map.isNotEmpty()) {
            val first = map.keys.first()
            for(i in 0 until groupSize) {
                val current = first+i
                if(current !in map) {
                    return false
                }

                map[current] = map[current]!! - 1
                if(map[current] == 0) {
                    map.remove(current)
                }
            }
        }

        return true
    }
}
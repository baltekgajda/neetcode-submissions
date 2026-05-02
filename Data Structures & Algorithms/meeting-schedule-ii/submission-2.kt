/**
 * Definition of Interval:
 * class Interval(var start: Int, var end: Int) {}
 */

class Solution {
    fun minMeetingRooms(intervals: List<Interval>): Int {
        val hm = mutableMapOf<Int, Int>()
        for(i in intervals) {
            hm[i.start] = hm.getOrDefault(i.start, 0) + 1
            hm[i.end] = hm.getOrDefault(i.end, 0) - 1
        }

        var current = 0
        var maxRooms = 0
        val timeframes = hm.keys.sorted()
        for(t in timeframes) {
            current += hm[t]!!
            maxRooms = max(maxRooms, current)
        }

        return maxRooms
    }
}

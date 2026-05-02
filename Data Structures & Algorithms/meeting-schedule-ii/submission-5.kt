/**
 * Definition of Interval:
 * class Interval(var start: Int, var end: Int) {}
 */

// two pointers
class Solution {
    fun minMeetingRooms(intervals: List<Interval>): Int {
        val starts = intervals.sortedBy {it.start}
        val ends = intervals.sortedBy {it.end}

        var startPointer = 0
        var endPointer = 0

        var rooms = 0
        var maxRooms = 0
        while(startPointer < intervals.size && endPointer < intervals.size) {
            if(starts[startPointer].start < ends[endPointer].end) {
                rooms++
                maxRooms = max(rooms, maxRooms)
                startPointer++
            } else {
                rooms--
                endPointer++
            }
        }

        return maxRooms
    }
}

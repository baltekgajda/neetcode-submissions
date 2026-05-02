/**
 * Definition of Interval:
 * class Interval(var start: Int, var end: Int) {}
 */

class Solution {
    fun minMeetingRooms(intervals: List<Interval>): Int {
        val sortedByStart = intervals.sortedBy {it.start}
        val minEndHeap = PriorityQueue<Interval>(compareBy {it.end})
        
        for(m in sortedByStart) {
            if(minEndHeap.size != 0 && minEndHeap.peek().end <= m.start) {
                minEndHeap.poll()
            }

            minEndHeap.add(m)
        }

        return minEndHeap.size
    }
}
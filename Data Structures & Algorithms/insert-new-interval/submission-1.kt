class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val result = mutableListOf<IntArray>()
        var newStart = newInterval[0]
        var newEnd = newInterval[1]

        var wasNewAdded = false
        for(i in intervals) {
            if(wasNewAdded) {
                result.add(i)
                continue
            }

            val iStart = i[0]
            val iEnd = i[1]

            if(newEnd < iStart) {
                result.add(intArrayOf(newStart, newEnd))
                result.add(i)
                wasNewAdded = true
                continue
            }

            if(newStart > iEnd) {
                result.add(i)
                continue
            }

            //overlaps
            newStart = min(newStart, iStart)
            newEnd = max(newEnd, iEnd)
        }

        if(!wasNewAdded) {
            result.add(intArrayOf(newStart, newEnd))
        }
                
        return result.toTypedArray()
    }
}

// 1. go through each interval
// 2. check whether end of new interval is before the start of i interval. if so you add newInterval, then i interval and all the remaining ones and return result
// 3. if end is smaller then new beg, then add i interval and continue
// 4. if new was already added, then just add the element and continue
// 5. now the case that it overlaps - you create that new beginning is where i begining is, end when larger of end is and continue the loop
// 6. return results. O(n)


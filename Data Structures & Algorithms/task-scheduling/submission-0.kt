class Solution {
    fun leastInterval(tasks: CharArray, n: Int): Int {
        val freq = IntArray(26) { 0 }
        val maxHeap = PriorityQueue<Int>(compareByDescending {it}) // only frequencies are needed
        for(t in tasks) {
            freq[t - 'A']++
        }

        for(c in 'A'..'Z') {
            if(freq[c-'A'] != 0)
                maxHeap.add(freq[c - 'A'])
        }

        val cooldownQueue = ArrayDeque<Pair<Int, Int>>() // first: how many times this task has to be done, second: min startTime
        var time = 0

        while(maxHeap.isNotEmpty() || cooldownQueue.isNotEmpty()) {
            var queueFirst = cooldownQueue.firstOrNull()
            while(queueFirst != null && queueFirst.second <= time) {
                cooldownQueue.removeFirst()
                maxHeap.add(queueFirst.first)
                queueFirst = cooldownQueue.firstOrNull()
            }

            if(maxHeap.isNotEmpty()) { // there is a task that can be used
                val task = maxHeap.poll()
                if(task > 1) {
                    cooldownQueue.addLast(task-1 to time + n + 1)
                }
            }

            time++
        }

        return time
    }
}

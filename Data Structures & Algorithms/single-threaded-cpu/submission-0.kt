class Solution {
    fun getOrder(tasks: Array<IntArray>): IntArray {
        val sortedIndices = tasks.indices.sortedBy { tasks[it][0] }

        val availableTasks = PriorityQueue<Pair<Int, Int>>( //index in tasks, processing time
            compareBy<Pair<Int,Int>> { it.second }.thenBy { it.first }
        )

        var time = 0
        var tasksInHeapIndex = 0
        var resultIndex = 0
        val result = IntArray(tasks.size) { 0 }
        while(resultIndex < tasks.size) {
            var addedTasks = 0
            for(i in tasksInHeapIndex until tasks.size) {
                val index = sortedIndices[i]
                if(tasks[index][0] > time) {
                    break
                }

                availableTasks.add(index to tasks[index][1])
                addedTasks++
            }

            tasksInHeapIndex += addedTasks

            if(availableTasks.isNotEmpty()) {
                val (i, pt) = availableTasks.poll()
                result[resultIndex] = i
                resultIndex++
                time += pt
            } else {
                time = tasks[sortedIndices[tasksInHeapIndex]][0]
            }
        }

        return result
    }
}

class Solution {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val adj = mutableMapOf<Int, MutableList<Int>>() //course with the ones we take later after that one
        val indegree = IntArray(numCourses) {0} //how many prerequisites has a course

        for(p in prerequisites) {
            adj.getOrPut(p[1]) {mutableListOf()}.add(p[0])
            indegree[p[0]]++
        }

        val queue = ArrayDeque<Int>()
        for(i in 0 until numCourses) {
            if(indegree[i] == 0) {
                queue.add(i)
            }
        }

        val visited = mutableSetOf<Int>()
        val order = IntArray(numCourses) {-1}
        var orderIndex = 0

        while(queue.isNotEmpty()) {
            val last = queue.removeFirst()
            visited.add(last)
            order[orderIndex] = last
            orderIndex++

            for(neighbor in adj[last] ?: mutableListOf()) {
                indegree[neighbor]--
                if(indegree[neighbor] == 0) {
                    queue.add(neighbor)
                }
            }
        }

        if(visited.size != numCourses) {
            return intArrayOf()
        }

        return order
    }
}

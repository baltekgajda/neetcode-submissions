class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
            val hm = mutableMapOf<Int, MutableList<Int>>()
            val required = IntArray(numCourses) {0}

            for(i in 0 until prerequisites.size) {
                val first = prerequisites[i][0]
                val second = prerequisites[i][1]

                if(first == second) {
                    return false
                }

                required[second]++
                hm.getOrPut(first) { mutableListOf() }.add(second)
            }

            val q = ArrayDeque<Int>() // courses that are not required for anything 
            for(i in 0 until numCourses) {
                if(required[i] == 0) {
                    q.add(i)
                }
            }

            var finish = 0
            while(q.isNotEmpty()) {
                val node = q.removeFirst()
                finish++
                for(other in (hm[node] ?: emptyList())) {
                    required[other]--
                    if(required[other] == 0) {
                        q.add(other)
                    }
                }
            }

            return finish == numCourses

    }
}

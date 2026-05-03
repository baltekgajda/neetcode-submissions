class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
            val hm = mutableMapOf<Int, MutableList<Int>>()

            for(i in 0 until prerequisites.size) {
                val first = prerequisites[i][0]
                val second = prerequisites[i][1]

                if(first == second) {
                    return false
                }

                hm.getOrPut(first) { mutableListOf() }.add(second)
            }

            val visiting = mutableSetOf<Int>()

            fun dfs(crs: Int): Boolean {
                if(crs in visiting) {
                    return false
                }

                if((hm[crs] ?: emptyList()).isEmpty()) {
                    return true
                }

                visiting.add(crs)
                for(c in hm[crs]!!) {
                    if(!dfs(c)) {
                        return false
                    }
                }

                visiting.remove(crs)
                hm[crs] = mutableListOf()
                return true
            }
            
            for (c in 0 until numCourses) {
                if (!dfs(c)) {
                    return false
                }
        }
            return true
    }
}

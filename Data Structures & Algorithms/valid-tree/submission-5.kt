class Solution {
    fun validTree(n: Int, edges: Array<IntArray>): Boolean {
        val neighbors = mutableMapOf<Int, Set<Int>>()
        for(e in edges) {
            neighbors[e[0]] = (neighbors[e[0]] ?: emptySet()) + e[1]
            neighbors[e[1]] = (neighbors[e[1]] ?: emptySet()) + e[0]
        }

        val visited = mutableSetOf<Int>()

        fun visitNode(previous: Int?, current: Int): Boolean {
            visited.add(current)
            val currentNeighbors = neighbors[current] ?: emptySet()
            for(n in currentNeighbors) {
                when {
                    n == previous -> continue
                    n in visited -> return false
                    else -> {
                        val result = visitNode(current, n)
                        if(!result) {
                            return false
                        }
                    }
                }
            }

            return true
        }

        val isValid = visitNode(null, 0)
        if(!isValid) {
            return false
        }

        return visited.size == n
    }
}
class Solution {
    fun countComponents(n: Int, edges: Array<IntArray>): Int {
        val parent = IntArray(n) { it }
        val rank = IntArray(n) { 1 }

        fun find(node: Int): Int {
            var res = node

            while(res != parent[res]) {
                res = parent[res]
            }

            return res
        }

        fun union(first: Int, second: Int): Int {
            val (firstParent, secondParent) = find(first) to find(second)
            if(firstParent == secondParent) {
                return 0
            }

            if(rank[firstParent] >= rank[secondParent]) {
                rank[firstParent] += rank[secondParent]
                parent[secondParent] = firstParent
            } else {
                rank[secondParent] += rank[firstParent]
                parent[firstParent] = secondParent
            }
            return 1
        }

        var components = n
        for(e in edges) {
            components -= union(e[0], e[1])
        }
        return components
    }
}

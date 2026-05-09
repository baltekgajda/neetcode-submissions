class Solution {
    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        val nodes = Array<MutableList<Int>>(edges.size+1) { mutableListOf()}
        for((i,e) in edges.withIndex()) {
            val (first, second) = e[0] to e[1]
            nodes[first].add(second)
            nodes[second].add(first)
        }

        val parent = IntArray(edges.size + 1) { it }
        val rank = IntArray(edges.size + 1) { 1 }

        fun find(node: Int): Int {
            var prnt = node
            while(parent[prnt] != prnt) {
                prnt = parent[prnt]
            }
            return prnt
        }

        fun union(node1: Int, node2: Int): Boolean {
            val (parent1, parent2) = find(node1) to find(node2)
            if(parent1 == parent2) {
                return false
            }

            if(rank[parent1] >= rank[parent2]) {
                rank[parent1] += rank[parent2]
                parent[parent2] = parent1
            } else {
                rank[parent2] += rank[parent1]
                parent[parent1] = parent2
            }

            return true
        }

        for(edge in edges) {
            val result = union(edge[0], edge[1])
            if(!result) {
                return edge
            }
        }
        
        return intArrayOf()
    }
}

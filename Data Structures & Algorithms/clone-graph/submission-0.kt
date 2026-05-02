/*
Definition for a Node.
class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList()
}
*/

class Solution {
    val visitedNodes = mutableMapOf<Int, Node>()
    fun cloneGraph(node: Node?): Node? {
        node ?: return null

        if(visitedNodes.contains(node.`val`)) {
            return visitedNodes[node.`val`]
        }

        val nodeCopy = Node(node.`val`)
        visitedNodes[node.`val`] = nodeCopy

        val neighbors = node.neighbors.map {
            cloneGraph(it)
        }

        nodeCopy.neighbors.addAll(neighbors)
        return nodeCopy
    }

    // 1. create hashset of visited nodes
    // 2. check whether node was visited O(1)
    // 3. create deep copy of node with neightbors - for each neighbor call cloneGraph()
    // 5. recursively get the whole graph O(V + 2E) = O(V+E)
}

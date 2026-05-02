/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        root ?: return emptyList()
        val queue = ArrayDeque<TreeNode>()
        queue.addLast(root)
        val result = mutableListOf<List<Int>>()

        while(queue.size != 0) {
            val level = mutableListOf<Int>()
            val levelSize = queue.size
            for(i in 0 until levelSize) {
                val node = queue.removeFirst()
                level.add(node.`val`)
                node.left?.let {queue.addLast(it)}
                node.right?.let {queue.addLast(it)}
            }
            result.add(level)
        }

        return result
    }
}

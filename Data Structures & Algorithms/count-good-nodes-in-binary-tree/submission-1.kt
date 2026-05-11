/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun goodNodes(root: TreeNode?): Int {
        var result = 0

        fun dfs(node: TreeNode?, maxHigher: Int) {
            if(node == null) {
                return
            }

            if(node.`val` >= maxHigher) {
                result++
            }

            val newMax = max(maxHigher, node.`val`)
            dfs(node.left, newMax)
            dfs(node.right, newMax)
        }

        dfs(root, -1000)
        return result
    }
}

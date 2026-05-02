/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun maxDepth(root: TreeNode?): Int {
        if(root == null) {
            return 0
        }

        val left = if(root?.left != null) {
            maxDepth(root.left!!)
        } else {
            0
        }

        val right = if(root?.right != null) {
            maxDepth(root.right!!)
        } else {
            0
        }

        return max(left, right) + 1
    }
}
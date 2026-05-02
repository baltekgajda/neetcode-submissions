/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */


class Solution {
    fun getTreeHeight(root: TreeNode?): Pair<Int, Boolean> {
        root ?: return Pair(0,true)

        val left = getTreeHeight(root.left)
        val right = getTreeHeight(root.right)

        val height = when {
            root.left == null && root.right == null -> 1
            else -> max(left.first, right.first) + 1
        }
        
        val balanced = left.second && right.second && kotlin.math.abs(left.first - right.first) <=1
        return height to balanced
    }

    fun isBalanced(root: TreeNode?): Boolean {
        root ?: return true
        return getTreeHeight(root).second
    }
}
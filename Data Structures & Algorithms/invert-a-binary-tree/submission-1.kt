/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun invertTree(root: TreeNode?): TreeNode? {
        root ?: return null
        return root?.apply {
            val temp = root.left
            left = invertTree(root.right)
            right = invertTree(temp)
        }
    }
}

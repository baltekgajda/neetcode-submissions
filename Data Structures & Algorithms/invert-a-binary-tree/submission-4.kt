/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun invertTree(root: TreeNode?): TreeNode? {
        val temp = root?.right
        root?.right = invertTree(root?.left)
        root?.left = invertTree(temp)
        return root
    }
}

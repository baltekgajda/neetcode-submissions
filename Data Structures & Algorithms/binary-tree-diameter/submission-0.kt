/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        root ?: return 0
        var longest = 0

        fun getLongerChild(node: TreeNode?): Int {
            val left = if(node?.left != null) getLongerChild(node.left) + 1 else 0
            val right = if(node?.right != null) getLongerChild(node.right) + 1 else 0
            longest = max(longest, left+right)
            return max(left,right)
        }

        getLongerChild(root)
        return longest
    }
}

/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        var longest = 0

        fun getLongerChild(node: TreeNode?): Int {
            if(node == null) {
                return -1
            }

            val left = getLongerChild(node?.left) + 1
            val right = getLongerChild(node?.right) + 1

            longest = listOf(longest, left, right, left+right).max()
            return max(left, right)
        }

        getLongerChild(root)

        return longest
    }
}

/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        return when {
            root == null && subRoot == null -> true
            root == null || subRoot == null -> false
            root.`val` == subRoot.`val` -> {
                if(root.left?.`val` == subRoot.left?.`val` && root.right?.`val` == subRoot.right?.`val`) {
                    isSubtree(root.left, subRoot.left) && isSubtree(root.right, subRoot.right)
                } else {
                    isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)
                }
            }
            else -> {
                isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)
            }
        }
    }
}

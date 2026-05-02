/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isValidBST(root: TreeNode?): Boolean {

        fun isValidNode(node: TreeNode?, smallerThan: Int?, largerThan: Int?): Boolean {
            node ?: return true

            if(smallerThan != null && node.`val` >= smallerThan) {
                return false
            }

            if(largerThan != null && node.`val` <= largerThan) {
                return false
            }

            return isValidNode(node.left, node.`val`, largerThan) 
                && isValidNode(node.right, smallerThan, node.`val`)
        }

        return isValidNode(root, null, null)
    }
}

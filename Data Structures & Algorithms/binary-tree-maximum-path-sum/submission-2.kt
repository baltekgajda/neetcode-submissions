/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    
    fun maxPathSum(node: TreeNode?): Int {
        var maxPath = Int.MIN_VALUE

        fun chooseMax(left: Int?, right: Int?, root: Int): Int {
            val l = left ?: 0
            val r = right ?: 0
            val result = listOf(l+root, r+root, l+r+root, root).max()
            return result
        }

        fun maxPathFun(root: TreeNode?): Int? { //WAZNE ZEBY NULL A NIE MIN_VALUE INT
            root ?: return null

            val leftLine = maxPathFun(root?.left)
            val rightLine = maxPathFun(root?.right)
            val straightLine = listOf(leftLine ?: 0, rightLine ?: 0, 0).max() + root?.`val`!!

            maxPath = listOf(maxPath, straightLine, chooseMax(leftLine, rightLine, root?.`val`!!)).max()
            return straightLine
        }

        maxPathFun(node)!!
        return maxPath
    }
}

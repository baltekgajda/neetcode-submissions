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
            1 + maxDepth(root.left!!)
        } else {
            1
        }

        val right = if(root?.right != null) {
            1 + maxDepth(root.right!!)
        } else {
            1
        }

        return max(left, right)
    }
}

// 1. iterate though the entire tree once
// 2. for each node check node level and compare to variable max_depth
// 3. return max_depth
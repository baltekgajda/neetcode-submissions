/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun rightSideView(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()

        fun dfs(node: TreeNode?, level: Int) {
            if(node == null) {
                return 
            }

            if(result.size <= level) {
                result.add(node.`val`)
            }

            dfs(node.right, level+1)
            dfs(node.left, level+1)
        }

        dfs(root, 0)
        return result
    }
}

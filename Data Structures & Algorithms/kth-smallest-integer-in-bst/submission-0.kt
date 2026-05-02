/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        var count = 0
        fun dfs(node: TreeNode?): Int? {
            node ?: return null

            val res = dfs(node?.left)
            if(res != null) {
                return res
            }

            count++
            if(count == k) {
                return node.`val`
            }

            return dfs(node?.right)
        }

        return dfs(root)!!
    }
}

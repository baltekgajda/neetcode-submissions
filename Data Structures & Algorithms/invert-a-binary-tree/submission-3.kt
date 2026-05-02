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
        
        val q = ArrayDeque<TreeNode?>()
        q.addLast(root)
        while(q.isNotEmpty()) {
            val node = q.removeFirst()
            node?.let {
                val temp = it.left
                it.left = it.right
                it.right = temp

                if(it.left!=null)
                    q.addLast(it.left)

                if(it.right!=null)
                    q.addLast(it.right)
            }
        }

        return root
    }
}

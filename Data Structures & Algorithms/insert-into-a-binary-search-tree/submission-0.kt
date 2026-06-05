/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun insertIntoBST(root: TreeNode?, `val`: Int): TreeNode? {
        if(root == null) {
            return TreeNode(`val`)
        }

        var node = root!!
        var added = false
        while(added == false) {
            if(`val` < node.`val`) {
                //left
                if(node.left == null) {
                    node.left = TreeNode(`val`)
                    added = true
                } else {
                    node = node.left!!
                }
            } else {
                //right
                if(node.right == null) {
                    node.right = TreeNode(`val`)
                    added = true
                } else {
                    node = node.right!!
                }
            }
        }

        return root
    }
}

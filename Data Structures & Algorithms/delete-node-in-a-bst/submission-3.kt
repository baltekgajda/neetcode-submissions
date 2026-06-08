/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
        val stubRoot = TreeNode(Int.MIN_VALUE)
        stubRoot.left = root

        val (node, parent) = findNode(root, stubRoot, key) ?: return root
        fun assignNewNode(newValue: TreeNode?) {
            if(parent.left == node) {
                parent.left = newValue
            } else {
                parent.right = newValue
            }
        }
        
        //no children
        if(node.left == null && node.right == null) {
            assignNewNode(null)
            return stubRoot.left
        }

        //one child only
        if(node.left == null) {
            assignNewNode(node.right)
            return stubRoot.left
        }

        //one child only
        if(node.right == null) {
            assignNewNode(node.left)
            return stubRoot.left
        }

        //two children
        var prev: TreeNode? = node
        var next: TreeNode? = node.right
        while(next?.left != null) {
            prev = next
            next = next?.left
        }

        node.`val` = next?.`val`!!
        if (prev == node) {
            prev.right = next?.right
        } else {
            prev?.left = next?.right
        }

        return stubRoot.left
    }

    fun findNode(node: TreeNode?, parent: TreeNode,  key: Int): Pair<TreeNode, TreeNode>? {
        node ?: return null

        if(node.`val` == key) {
            return node to parent
        }

        return if(key < node.`val`) {
            findNode(node?.left, node!!, key)
        } else {
            findNode(node?.right, node!!, key)
        }
    }
}

/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        //define trees as lists in preorder traversal order
        val rootList = getTreePreorderList(root).joinToString(".")
        val subRootList = getTreePreorderList(subRoot).joinToString(".")

        println(rootList)
        println(subRootList)
        return rootList.contains(subRootList)
    }

    //preorder traversal
    fun getTreePreorderList(root: TreeNode?): List<Int?> {
        root ?: return listOf(null)

        val res = mutableListOf<Int>()
        return listOf(root.`val`) + getTreePreorderList(root.left) + getTreePreorderList(root.right)
    }
}

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
        return checkStringsContain(rootList, subRootList)
    }

    //preorder traversal
    fun getTreePreorderList(root: TreeNode?): List<String> {
        root ?: return listOf("$")

        val res = mutableListOf<String>()
        return listOf(root.`val`.toString()) + getTreePreorderList(root.left) + getTreePreorderList(root.right)
    }

    fun checkStringsContain(fraze: String, pattern: String): Boolean {
        val lps = buildLongestPrefixArray(pattern)
        println(lps.toList())
        
        var i = 0 //lps pointer (pattern pointer)
        var j = 0 // fraze pointer

        while(i < pattern.length) {
            if(j >= fraze.length) {
                return false
            }

            if(fraze[j] == pattern[i]) {
                j++
                i++
            } else if(i == 0) {
                j++
            } else {
                i = lps.getOrNull(i-1) ?: 0
            }
        }

        return true
    }

    fun buildLongestPrefixArray(pattern: String): IntArray {
        val lps = IntArray(pattern.length)
        
        var i = 1
        var j = 0
        while(i<pattern.length) {
            if(pattern[j] == pattern[i]) {
                lps[i] = j+1
                j++
                i++
            } else if(j == 0) {
                lps[i] = 0
                i++
            } else {
                j=0
            }
        }

        return lps
    }
}

/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        val rootString = createTreeString(root).joinToString("+")
        val subRootString = createTreeString(subRoot).joinToString("+")

        return checkStringContains(rootString, subRootString)
    }

    fun createTreeString(root: TreeNode?): List<String> {
        root ?: return listOf("$")
        return listOf(root.`val`.toString()) + createTreeString(root.left) + createTreeString(root.right)
    }

    fun checkStringContains(str: String, pattern: String): Boolean {
        val lpa = getLongestPrefixArray(pattern)
        var strIndex = 0
        var patternIndex = 0
    
        while (patternIndex < pattern.length) {
            if(strIndex == str.length) {
                return false
            }

            if(str[strIndex] == pattern[patternIndex]) {
                strIndex++
                patternIndex++
            } else if(patternIndex == 0) {
                strIndex++
            } else {
                patternIndex = lpa.getOrNull(patternIndex-1) ?: 0
            }
        }

        return true
    }

    fun getLongestPrefixArray(pattern: String): List<Int> {
        val lpa = IntArray(pattern.length) // initialized with 0s
        var patternIndex = 1
        var repeatIndex = 0

        while(patternIndex < pattern.length) {
            if(pattern[patternIndex] == pattern[repeatIndex]) {
                lpa[patternIndex] = repeatIndex + 1
                repeatIndex++
                patternIndex++
            } else if(repeatIndex == 0) {
                lpa[patternIndex] = 0
                patternIndex++
            } else {
                repeatIndex = 0
            }
        }

        return lpa.toList()
    }
}

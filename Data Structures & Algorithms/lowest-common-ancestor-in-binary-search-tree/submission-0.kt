/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        root ?: return null
        p ?: return null
        q ?: return null

        return when {
            root.`val` == p.`val` || root.`val` == q.`val` -> root
            root.`val` < p.`val` && root.`val` < q.`val` -> lowestCommonAncestor(root.right, p, q)
            root.`val` > p.`val` && root.`val` > q.`val` -> lowestCommonAncestor(root.left, p, q)
            else -> root
        }
    }

    // 1. compare p and q to root
    // 2. if one is smaller, one larger then root then root is the answer
    // 3. if they are both smaller or both larger, we repeat lowerstCommonAncestor to the child of root as new root
    // 4. if root is one of p or q then it is the answer
    // O(n) would be O(logn) because we go in half every time
}

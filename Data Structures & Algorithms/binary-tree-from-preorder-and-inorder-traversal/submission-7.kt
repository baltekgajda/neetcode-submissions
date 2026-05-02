/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        if (preorder.isEmpty() || inorder.isEmpty()) {
            return null
        }

        val root = TreeNode(preorder[0])

        val mid = inorder.indexOf(preorder[0])

        //ZAUWAZYC ZE DLUGOSC PRAWEGO I LEWEGO BEDZIE TAKA SAMA W OBU LISTACH WIEC MOZNA UZYC INDEKSU
        root.left = buildTree(
            preorder.slice(1..mid).toIntArray(),
            inorder.slice(0 until mid).toIntArray()
        )

        root.right = buildTree(
            preorder.slice(mid+1 until preorder.size).toIntArray(),
            inorder.slice(mid+1 until inorder.size).toIntArray()
        )

        return root
    }
}

// preorder root left right
// inorder left root right


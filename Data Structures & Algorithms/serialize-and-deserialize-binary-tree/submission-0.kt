/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Codec {
    // Encodes a tree to a single string.
    fun serialize(root: TreeNode?): String {
        val result = mutableListOf<String>()
        if(root == null) {
            return "N"
        }

        
        return root.`val`.toString() + "#" + serialize(root?.left) + serialize(root?.right)
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {

        //returns first of first unused char
        fun deserializ(startIndex: Int): Pair<TreeNode?, Int> {
            if(data[startIndex] == 'N') {
                return null to startIndex+1
            }

            var index = startIndex
            while(data[index] != '#') {
                index++
            }
            
            val value = data.substring(startIndex, index).toInt()
            val node = TreeNode(value)
            val (left, nextIndex) = deserializ(index+1)
            val (right, returnIndex) = deserializ(nextIndex)
            node.left = left
            node.right = right
            return node to returnIndex
        }

        return deserializ(0).first
    }
}

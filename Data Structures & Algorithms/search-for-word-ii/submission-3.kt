class TreeNode {
    val children = Array<TreeNode?>(26) { null }
    var prefixWords = 0
    var wordIndex = -1
}

class PrefixTree {
    val root = TreeNode()

    fun add(word: String, index: Int) {
        if(word.length == 0) {
            return
        }

        var node = root
        node.prefixWords++
        for(c in word) {
            val next = node.children[c-'a']
            if(next == null) {
                val newNode = TreeNode()
                node.children[c-'a'] = newNode
                node = newNode
            } else {
                node = next
            }
            node.prefixWords++
        }
        node.wordIndex = index
    }
}

class Solution {
    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
        val prefixTree = PrefixTree()
        for((i, w) in words.withIndex()) {
            prefixTree.add(w, i)
        }

        val result = mutableListOf<String>()

        fun findWord(coords: Pair<Int, Int>, node: TreeNode?) {
            val (r, c) = coords
            if(r<0 || r>=board.size || c <0 || c>=board[0].size || board[r][c] == '#' || node?.children[board[r][c] - 'a'] == null) {
                return
            }

            val temp = board[r][c]
            board[r][c] = '#'
            val prev = node!!
            val nextNode = node?.children[temp-'a']!!

            if(nextNode.wordIndex != -1) {
                result.add(words[nextNode.wordIndex])
                nextNode.wordIndex = -1
                nextNode.prefixWords--
                if(nextNode.prefixWords == 0) {
                    prev.children[temp-'a'] = null
                    board[r][c] = temp
                    return 
                }
            }

            findWord(r + 1 to c, nextNode)
            findWord(r - 1 to c, nextNode)
            findWord(r to c + 1, nextNode)
            findWord(r to c - 1, nextNode)

            board[r][c] = temp
        }
        
        for(row in 0 until board.size) {
            for(column in 0 until board[0].size) {
                findWord(row to column, prefixTree.root)
            }
        }

        return result
    }
}
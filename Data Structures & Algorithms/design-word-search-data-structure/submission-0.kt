class Node {
    val next = mutableMapOf<Char,Node>()
    var wordExists = false

    fun addWord(word: String) {
        var nextNode = this
        for(c in word) {
            nextNode = nextNode.next.getOrPut(c) { Node() }
        }
        nextNode.wordExists = true
    }
}

class WordDictionary {
    val root = Node()

    fun addWord(word: String) {
        root.addWord(word)
    }

    fun search(word: String): Boolean {
        val queue = ArrayDeque<Node>()
        queue.add(root)
        for(c in word) {
            val toAdd = mutableListOf<Node>()
            while(queue.size != 0) {
                val node = queue.removeFirst()
                if(c != '.') {
                    val newNode = node.next[c] ?: continue
                    toAdd.add(newNode)
                } else {
                    toAdd.addAll(node.next.values.toList())
                }
            }
            queue.addAll(toAdd)
        }

        if(queue.size == 0 || queue.toList().filter { it.wordExists }.size < 1) {
            return false
        } else {
            return true
        }

        return true
    }
}

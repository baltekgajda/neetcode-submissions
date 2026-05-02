class Node(val v: Char?) {
    var word = false // marks end of word
    val hm = mutableMapOf<Char, Node>()
}

class PrefixTree {
    val root = Node(null)

    fun insert(word: String) {
        var node = root
        for(c in word) {
            if(c !in node.hm) {
                node.hm[c] = Node(c)
            }
            node = node.hm[c]!!
        }

        node.word = true
    }

    fun search(word: String): Boolean {
        var node = root
        for(c in word) {
            if(c in node.hm) {
                node = node.hm[c]!!
            } else {
                return false
            }
        }
        
        return node.word
    }

    fun startsWith(prefix: String): Boolean {
        var node = root
        for(c in prefix) {
            if(c in node.hm) {
                node = node.hm[c]!!
            } else {
                return false
            }
        }
        
        return true
    }
}

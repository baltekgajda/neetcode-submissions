class Solution {
    fun ladderLength(beginWord: String, endWord: String, wordList: MutableList<String>): Int {
        val nodes = mutableMapOf<String, MutableList<String>>()
        val visited = mutableSetOf<String>()
        wordList.add(beginWord)

        for(word in wordList) {
            val wordArray = word.toCharArray()
            for(i in 0 until wordArray.size) {
                val temp = wordArray[i]
                wordArray[i] = '*'
                nodes.getOrPut(String(wordArray)) {mutableListOf()}.add(word)
                nodes.getOrPut(word) {mutableListOf()}.add(String(wordArray))
                wordArray[i] = temp
            }
        }

        val queue = ArrayDeque<String>()
        queue.add(beginWord)
        visited.add(beginWord)
        var result = 0

        while(queue.isNotEmpty()) {
            result++
            repeat(queue.size) {
                val node = queue.removeFirst()
               
                if(node == endWord) {
                    return result/2 + 1
                }

                for(neighbor in nodes[node]!!) {
                    if(neighbor in visited) {
                        continue
                    }

                    visited.add(neighbor)
                    queue.add(neighbor)
                }
            }
        }

        return 0
    }
}

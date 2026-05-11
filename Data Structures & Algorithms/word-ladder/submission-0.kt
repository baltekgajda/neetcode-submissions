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

        val minHeap = PriorityQueue<Pair<String, Int>>(compareBy{it.second})
        minHeap.add(beginWord to 0)

        while(minHeap.isNotEmpty()) {
            val (node, dist) = minHeap.poll()
            visited.add(node)

            if(node == endWord) {
                    return dist/2 + 1
                }

            for(neighbor in nodes[node] ?: emptyList()) {
                if(neighbor in visited) {
                    continue
                }

                visited.add(neighbor)
                minHeap.add(neighbor to (dist + 1))
            }
        }

        return 0
    }
}

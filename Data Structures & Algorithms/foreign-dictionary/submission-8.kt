class Solution {
    fun foreignDictionary(words: Array<String>): String {
        val smallerMap = mutableMapOf<Char, Int>()
        val adj = mutableMapOf<Char, MutableSet<Char>>()
        val letters = mutableSetOf<Char>()

        for(i in 0 until words.size) {
            val first = words[i]
            for(c in first) {
                letters.add(c)
            }

            val second = words.getOrNull(i+1) ?: break

            var sameLetters = 0
            for(j in 0 until min(first.length, second.length)) {
                if(first[j] == second[j]) {
                    sameLetters++
                    continue
                }

                if(second[j] !in (adj[first[j]] ?: mutableSetOf())) {
                    smallerMap[second[j]] = (smallerMap[second[j]] ?: 0) + 1
                }
                adj.getOrPut(first[j]) {mutableSetOf()}.add(second[j])
                break
            }

            if(sameLetters == min(first.length, second.length) && first.length > second.length) {
                return ""
            }
        }

        println(smallerMap.toList())
        println("----------")
        println(adj.toList())

        val queue = ArrayDeque<Char>()
        for(l in letters) {
            if(l !in smallerMap || smallerMap[l] == 0) {
                queue.add(l)
            }
        }

        val result = mutableListOf<Char>()
        var visited = 0
        while(queue.size != 0) {
            val item = queue.removeFirst()
            result.add(item)
            visited++

            if(item !in adj) {
                continue
            }

            for(c in adj[item]!!) {
                smallerMap[c] = smallerMap[c]!! - 1
                if(smallerMap[c] == 0) {
                    queue.add(c)
                }
            }
        }

        if(visited != letters.size) {
            return ""
        }
        
        return result.joinToString("")
    }
}


// 1. set to store all letters in the language
// 2. hashmap key - smaller , value set of larger
// 3. we have create adjecency list of a graph
// 4. we find all vertices (letters) that are not in values (letter no letter is smaller then them)
// 5. we go topological sorting of the tree
// 6. create a queue of vertices from point 4 and check connected, after checking we add them to result
// 7. if they have no predecessors now, we add them to queue as well
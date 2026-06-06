class Solution {
    fun reorganizeString(s: String): String {
        val freq = IntArray(26) {0}
        for(c in s) {
            freq[c - 'a'] += 1
        }

        val heap = PriorityQueue<Pair<Char, Int>>(compareByDescending { it.second })
        for(c in 'a'..'z') {
            if(freq[c - 'a'] > 0)
                heap.add(c to freq[c - 'a'])
        }

        val result = mutableListOf<Char>()
        while(heap.isNotEmpty()) {
            val (c, f) = heap.poll()
            if(result.lastOrNull() == c) {
                if(heap.isEmpty()) {
                    return ""
                } else {
                    val (c2, f2) = heap.poll()
                    result.add(c2)
                    result.add(c)
                    if(f > 1) {
                        heap.add(c to f - 1)
                    }

                    if(f2 > 1) {
                        heap.add(c2 to f2 - 1)
                    }
                }
            } else {
                result.add(c)
                if(f > 1) {
                    heap.add(c to f - 1)
                }
            }
        }

        return result.joinToString("")
    }
}

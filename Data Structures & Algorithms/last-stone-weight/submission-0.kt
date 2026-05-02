class Solution {
    fun lastStoneWeight(stones: IntArray): Int {
        val heap = PriorityQueue<Int>(compareByDescending {it})
        for(s in stones) {
            heap.add(s)
        }

        while(heap.size > 1) {
            val first = heap.poll()
            val second = heap.poll()
            if(first != second) {
                heap.add(kotlin.math.abs(first-second))
            }
        }

        return if(heap.size == 0) 0 else heap.peek()
    }

    //create max-heap (log n)
    // take two heaviest elems from the heap 0(logn)
    //smash them and add remainings of heavier stone to heap 0(logn)
    // do that until there are us only one stone left
}

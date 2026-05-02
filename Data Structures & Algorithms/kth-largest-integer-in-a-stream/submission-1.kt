class KthLargest(k: Int, nums: IntArray) {
    val heap = PriorityQueue<Int>()
    val k = k

    init {
        for(n in nums) {
            heap.add(n)
        }

        while(heap.size > k) {
            heap.poll()
        } // left with k largest
    }
    
    

    fun add(`val`: Int): Int {
        heap.add(`val`)
        if(heap.size > k) {
            val r = heap.poll()
        }

        return heap.peek()
    }
}

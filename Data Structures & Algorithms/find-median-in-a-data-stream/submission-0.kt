class MedianFinder {
    val smallerHalf = PriorityQueue<Int>(compareByDescending {it})
    val largerHalf = PriorityQueue<Int>()
    
    fun addNum(num: Int) {
        val smaller = smallerHalf.peek() ?: Int.MIN_VALUE
        val larger = largerHalf.peek() ?: Int.MIN_VALUE

        if(num < smaller) {
            smallerHalf.add(num)
        } else {
            largerHalf.add(num)
        }

        while(kotlin.math.abs(smallerHalf.size - largerHalf.size) > 1) {
            if(smallerHalf.size < largerHalf.size) {
                smallerHalf.add(largerHalf.poll())
            } else {
                largerHalf.add(smallerHalf.poll())
            }
        }
    }

    fun findMedian(): Double {
        if(smallerHalf.size == 0 && largerHalf.size == 0) {
            return 0.0
        }

        return if(smallerHalf.size < largerHalf.size) {
            largerHalf.peek().toDouble()
        } else if(smallerHalf.size > largerHalf.size) {
            smallerHalf.peek().toDouble()
        } else {
            (largerHalf.peek() + smallerHalf.peek()) / 2.0
        }
    }
}
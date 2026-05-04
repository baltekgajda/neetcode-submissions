/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val head = ListNode(0)
        var next = head
        val minHeap = PriorityQueue<ListNode>(compareBy {it.`val`})
        
        for(i in 0 until lists.size) {
            if(lists[i] != null) {
                minHeap.add(lists[i])
            }
        }

        while(minHeap.size != 0) {
            val node = minHeap.poll()
            if(node?.next != null) {
                minHeap.add(node?.next)
            }
            
            next?.next = node
            next = node 
        }

        return head?.next
    }
}

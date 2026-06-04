/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head

        var prev: ListNode? = dummy  // <-- zaczyna od dummy
        var node: ListNode? = head
        var counter = 1
        while(counter != left) {
            prev = node
            node = node?.next
            counter++
        }

        fun reverseList(start: ListNode?): Pair<ListNode?, ListNode?> {
            var prev: ListNode? = null
            var node = start

            while(counter != right + 1) {
                val temp = node?.next
                node?.next = prev
                prev = node
                node = temp
                counter++
            }

            return (prev to node)
        }

        val (newHead, nextNode) = reverseList(node)
        prev?.next = newHead
        node?.next = nextNode
        return dummy.next  // <-- nie head, bo head mógł się zmienić
    }
}

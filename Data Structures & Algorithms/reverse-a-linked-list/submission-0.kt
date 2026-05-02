/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        val listString = mutableListOf<Int>()
        head ?: return null

        var next = head
        var previous: ListNode? = null
        while(next != null) {
            val temp = previous
            previous = ListNode(next.`val`)
            previous.next = temp
            next = next.next
        }

        return previous
    }
}

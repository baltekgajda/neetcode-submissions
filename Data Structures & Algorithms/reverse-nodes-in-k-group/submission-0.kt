/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {

    fun reverseList(head: ListNode?, k: Int): ListNode? {
        var current = head
        var prev: ListNode? = null
        var counter = 0

        while(counter < k) {
            if(current == null) {
                return head
            }

            counter++
            current = current.next
        }

        current = head
        counter = 0

        while(counter < k) {
            val temp = current?.next
            current?.next = prev
            prev = current
            current = temp
            counter++
        }

        val nextHead = reverseList(current, k)
        head?.next = nextHead
        return prev
    }

    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        if(k == 1 || head == null) {
            return head
        }

        return reverseList(head, k)
    }
}

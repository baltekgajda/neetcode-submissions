/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        if(head == null) {
            return null
        }
        
        var len = 0
        var next: ListNode? = head
        while (next!= null) {
            len++
            next = next.next
        }

        val removeIndex = len-n
        if(removeIndex == 0) {
            return head?.next
        }

        var counter = 0
        next = head
        while(counter < removeIndex - 1) {
            counter++
            next = next?.next
        }

        next?.next = next?.next?.next
        return head
    }
}

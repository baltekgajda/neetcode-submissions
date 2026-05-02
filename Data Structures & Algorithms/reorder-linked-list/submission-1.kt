/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun revertList(head: ListNode): ListNode {
        val next = head.next ?: return head
        val reverted = revertList(next)
        next.next = head
        head.next = null
        return reverted
    }

    fun reorderList(head: ListNode?): Unit {
        if(head == null || head?.next == null) return

        var slow: ListNode? = head
        var fast: ListNode? = head
        while(fast != null && fast.next != null) {
            slow = slow?.next
            fast = fast?.next?.next
        }

        val reversed = revertList(slow?.next!!)
        slow?.next = null

        var node: ListNode? = head
        var rNode: ListNode? = reversed
        while(node != null && rNode!= null) {
            val temp = node.next
            val rTemp = rNode.next

            node.next = rNode
            rNode.next = temp
            node = temp
            rNode = rTemp
        }
    }
}

/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    var carry = 0
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        if(l1 == null && l2 == null && carry == 0) {
            return null
        }

        val l1Val = l1?.`val` ?: 0
        val l2Val = l2?.`val` ?: 0

        val added = l1Val + l2Val + carry

        val newNode = ListNode(added % 10)
        carry = added/10
        newNode.next = addTwoNumbers(l1?.next, l2?.next)
        return newNode
    }
}

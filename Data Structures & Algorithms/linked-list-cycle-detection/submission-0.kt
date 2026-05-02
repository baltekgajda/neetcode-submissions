/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {

    fun hasCycle(head: ListNode?): Boolean {
        val REPEATED_VALUE = 1111
        
        var node = head
        while(node!=null) {
            if(node.`val` == REPEATED_VALUE) {
                return true
            } else {
                node.`val` = REPEATED_VALUE
                node = node.next
            }
        }

        return false
    }
}

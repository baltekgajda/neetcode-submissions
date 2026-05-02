/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        return when {
            list1 == null -> list2
            list2 == null -> list1
            list1.`val` <= list2.`val` -> {
                ListNode(list1.`val`).apply {
                    next = mergeTwoLists(list1.next, list2)
                }
            }
            else -> {
                ListNode(list2.`val`).apply {
                    next = mergeTwoLists(list1, list2.next)
                }
            }
        }
    }
}

// 1. compare two heads, choose it to be the head
// 2. run mergeTwoLists on remainings of both lists - the head used
// 3. add merged list as next
// 4. in case both lists are empty return null
// 5. if one is empty, second one is 
/*
// Definition for a Node.
class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}
*/

class Solution {
    fun copyList(head: Node?) : Node? {
        if(head == null) {
            return null
        }

        val newHead = Node(head.`val`)
        newHead.next = copyList(head.next)
        return newHead
    }

    val hm = mutableMapOf<Node, Node>()

    fun copyRandomList(head: Node?): Node? {
        val newHead = copyList(head)

        var next = head
        var newNext = newHead
        while(next != null) {
            hm[next] = newNext!!
            next = next?.next
            newNext = newNext?.next
        }

        next = head
        newNext = newHead
        while(next != null) {
            val random = next?.random
            if(random != null) {
                val newRandom = hm[random]
                newNext?.random = newRandom
            }

            next = next?.next
            newNext = newNext?.next
        }

        return newHead
    }
}

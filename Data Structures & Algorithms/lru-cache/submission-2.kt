class Node(val key: Int? = null, val value: Int? = null) {
    var prev: Node? = null
    var next: Node? = null
}

class LRUCache(private val capacity: Int) {

    val hm = mutableMapOf<Int, Node>()

    val first = Node()  //best way is to have first and last and never remove them which helps add and remove other nodes
    val last = Node()

    init {
        first.next = last
        last.prev = first
    }

    fun addLast(key: Int, value: Int) {
        val lastNode = last.prev
        val newNode = Node(key, value)
        lastNode?.next = newNode
        newNode.prev = lastNode
        newNode.next = last
        last.prev = newNode
        hm[key] = newNode
    }

    //we ensure key is in the map
    fun remove(key: Int) {
        remove(hm[key]!!)
    }

    fun remove(node: Node) {
        val prev = node?.prev
        val next = node?.next

        prev?.next = next
        next?.prev = prev
        node.next = null
        node.prev = null

        hm.remove(node.key)
    }

    fun get(key: Int): Int {
        if(key !in hm) {
            return -1
        }

        val value = hm[key]!!

        remove(key)
        addLast(key, value.value!!)
        return value.value!!
    }

    fun put(key: Int, value: Int) {
        if(key in hm) {
            remove(key)
        }

        addLast(key, value)
        if(hm.size > capacity) {
            remove(first?.next!!)
        }
    }
}

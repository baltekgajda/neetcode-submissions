class Solution {
    fun findItinerary(tickets: List<List<String>>): List<String> {
        val adj = mutableMapOf<String, ArrayDeque<String>>()
        tickets.sortedWith(compareBy({ it[0]},{it[1]}))
            .forEach { (src, dst) ->
                adj.getOrPut(src) { ArrayDeque() }.addLast(dst)
            }

        val result = mutableListOf<String>()

        fun dfs(scr: String) {
            while(scr in adj && adj[scr]?.isNotEmpty()!!) {
                val next = adj[scr]?.removeFirst()!!
                dfs(next)
            }

            result.add(scr)
        }

        dfs("JFK")
        return result.reversed()
    }
}

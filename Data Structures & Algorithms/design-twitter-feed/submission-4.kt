class Twitter {

    val follows = mutableMapOf<Int, MutableSet<Int>>()
    val userPosts = mutableMapOf<Int, MutableList<Pair<Int,Int>>>()
    var time = 0

    fun postTweet(userId: Int, tweetId: Int) {
        userPosts.getOrPut(userId) { mutableListOf()}.add(tweetId to time)
        time++
    }

    fun getNewsFeed(userId: Int): List<Int> {
        follow(userId, userId)

        val postsToShow = PriorityQueue<Pair<Int,Int>>(compareBy {it.second}) //biggest on top
        for(followeeId in follows[userId]!!) {
            if(userPosts[followeeId] == null) {
                continue
            }

            for(post in userPosts[followeeId]!!.takeLast(10)) {
                postsToShow.add(post)
                if(postsToShow.size > 10) {
                    postsToShow.poll()
                }
            }
        }

        val result = mutableListOf<Int>()
        while(postsToShow.isNotEmpty()) {
            result.add(postsToShow.poll().first)
        }

        return result.reversed()
    }

    fun follow(followerId: Int, followeeId: Int) {
        follows.getOrPut(followerId) { mutableSetOf() }.add(followeeId)
    }

    fun unfollow(followerId: Int, followeeId: Int) {
        follows.getOrPut(followerId) { mutableSetOf() }.remove(followeeId)
    }
}

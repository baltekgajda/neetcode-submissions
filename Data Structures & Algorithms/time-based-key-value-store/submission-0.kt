class TimeMap() {
    val hm = mutableMapOf<String, MutableList<Pair<Int, String>>>()
    fun set(key: String, value: String, timestamp: Int) {
        hm.getOrPut(key) {mutableListOf()}.add(timestamp to value)
    }

    fun get(key: String, timestamp: Int): String {
        val value = hm[key] ?: return ""
        if(value.isEmpty() || value.first().first > timestamp) {
            return ""
        }

        var result = ""
        var l = 0
        var r = value.size - 1
        
        while(l <= r) {
            val middle = (l+r) / 2
            
            if(value[middle].first <= timestamp) {
                result = value[middle].second
                l = middle+1
            } else {
                r = middle-1
            }
        }

        return result
    }
}

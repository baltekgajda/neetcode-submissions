class Solution {
    fun reverse(x: Int): Int {
        val sx = if(x < 0) {
            x.toString().drop(1)
        } else {
            x.toString()
        }

        var result = 0L
        var multiplier = 1L
        for(c in sx) {
            result += c.digitToInt().toLong() * multiplier
            multiplier *= 10
        }

        if(x < 0) {
            result *= -1
        }

        println(result)

        return if(result < Int.MIN_VALUE.toLong() || result > Int.MAX_VALUE.toLong()) {
            0
        } else {
            result.toInt()
        }
    }
}

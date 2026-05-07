class CountSquares {

    val coords = mutableMapOf<Pair<Int, Int>, Int>() // store how many poins with the same coords there are

    fun add(point: IntArray) {
        coords[point[0] to point[1]] = (coords[point[0] to point[1]] ?: 0) + 1
    }

    fun count(point: IntArray): Int {
        var result = 0

        // we look for diagonal points that create a square
        for((coord, freq) in coords.entries) {
            if(kotlin.math.abs(coord.first - point[0]) != kotlin.math.abs(coord.second - point[1])
                || coord.first == point[0] || coord.second == point[1]) {
                continue
            }

            val thirdPoint = coords[coord.first to point[1]] ?: 0
            val forthPoint = coords[point[0] to coord.second] ?: 0

            result += freq * thirdPoint * forthPoint
        }

        return result
    }
}

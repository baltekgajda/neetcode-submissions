class Solution {
    fun numRescueBoats(people: IntArray, limit: Int): Int {
        people.sort()
        var i = 0
        var j = people.size - 1
        var result = 0
        while (i <= j) {
            result++

            if(i == j) {
                break
            }

            var boat = people[i] + people[j]
            if(boat <= limit) {
                i++
            }

            j--
        }

        return result
    }
}
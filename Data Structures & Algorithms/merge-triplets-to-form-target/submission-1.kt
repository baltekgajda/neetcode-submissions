class Solution {
    fun mergeTriplets(triplets: Array<IntArray>, target: IntArray): Boolean {
        var maxA = 0
        var maxB = 0
        var maxC = 0

        for(t in triplets) {
            if(t[0] > target[0] || t[1] > target[1] || t[2] > target[2]) {
                continue
            }

            maxA = max(maxA, t[0])
            maxB = max(maxB, t[1])
            maxC = max(maxC, t[2])

            if(maxA == target[0] && maxB == target[1] && maxC == target[2]) {
                return true
            }
        }

        return false
    }
}

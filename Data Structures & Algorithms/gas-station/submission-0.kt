class Solution {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {

        var start = 0
        var currentGas = 0
        for(i in 0 until gas.size) {
            currentGas += gas[i] - cost[i]
            if(currentGas < 0) {
                start = i+1
                currentGas = 0
            }
        }

        for(i in 0 until start) {
            currentGas += gas[i] - cost[i]
            if(currentGas < 0) {
                return -1
            }
        }

        return start
    }
}

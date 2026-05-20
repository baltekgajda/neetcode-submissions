class Solution {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        if(gas.sum() < cost.sum()) { //to be able to have solution sum(gas) - sum(cost) >= 0 thus this check
            return -1
        }

        var start = 0
        var currentGas = 0

        for(i in 0 until gas.size) {
            currentGas += gas[i] - cost[i]
            if(currentGas < 0) {
                start = i+1
                currentGas = 0
            }
        }

        //we have accumulated some sum stored in currentGas
        //we know that gas.sum() - cost.sum() >= 0 therefore we know that we can use
        //current gas to get to all stations
        return start
    }
}

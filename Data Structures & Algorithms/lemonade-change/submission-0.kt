class Solution {
    fun lemonadeChange(bills: IntArray): Boolean {
        var fivs = 0
        var tens = 0

        for(bill in bills) {
            when {
                bill == 5 -> {
                    fivs++
                }
                bill == 10 -> {
                    fivs--
                    tens++
                    if(fivs < 0) {
                        return false
                    }
                }
                tens >= 1 && fivs >= 1 -> {
                    fivs--
                    tens--
                }
                else -> {
                    fivs-=3
                    if(fivs < 0) {
                        return false
                    }
                }
            } 
        }

        return true
    }
}

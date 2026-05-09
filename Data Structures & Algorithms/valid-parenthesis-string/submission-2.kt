class Solution {
    fun checkValidString(s: String): Boolean {
        var leftMin = 0 //track how many left parenthesis there is min
        var leftMax = 0

        for(c in s) {
            when(c) {
                '(' -> {
                    leftMin++
                    leftMax++
                }
                ')' -> {
                    leftMin--
                    leftMax--
                }
                else -> {
                    leftMin = max(0, leftMin-1) // use * as )
                    leftMax++
                }
            }
                if(leftMin < 0) leftMin = 0
                if(leftMax < 0) return false
        }

        return leftMin == 0
    }
}

/**
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return       -1 if num is higher than the picked number
 *                1 if num is lower than the picked number
 *               otherwise return 0
 * fun guess(num: Int): Int
 */

class Solution : GuessGame() {
    fun guessNumber(n: Int): Int {
        var left = 1
        var right = n

        while(left<=right) {
            val middle = left + (right - left) / 2
            val guess = guess(middle)

            when (guess) {
                0 -> return middle
                -1 -> {
                    right = middle-1
                }
                else -> {
                    left = middle+1  
                }
            }
        }

        return -1
    }
}

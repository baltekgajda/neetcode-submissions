class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var i = 0
        var j = numbers.size - 1

        while (i < j) {
            val sum = numbers[i] + numbers[j]
            when {
                sum == target -> return intArrayOf(i+1, j+1)
                sum > target -> j--
                sum < target -> i++
            }
        }

        return intArrayOf(-1)
    }
}
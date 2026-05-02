class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val result = IntArray(nums.size)
        var product = 1
        val zeros= mutableSetOf<Int>()
        for((i,n) in nums.withIndex()) {
            if(n == 0) {
                zeros.add(i)
            } else {
                product *= n
            }
        }

        for(i in 0 until nums.size) {
            result[i] = when {
                zeros.isEmpty() -> product/nums[i]
                nums[i] == 0 && zeros.size == 1 -> product
                nums[i] == 0 && zeros.size != 1 -> 0
                else -> 0
            }
        }

        return result
    }
}

// 1. iterate though the whole nums array to calculate the product
// 2. if there are zeros we dont calculate them in the product
// 3. we iterate through the result array - if index is in zeros, we return product * remaining zeros
// 4. if index is not in zeros but there are zeros we return zero
// 5. if index is not in zeros and there are no zeros we return product divided by nums[index]
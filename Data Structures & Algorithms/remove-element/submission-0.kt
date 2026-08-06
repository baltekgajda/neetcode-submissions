class Solution {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var indexToPut = 0
        var counter = 0

        for(n in nums) {
            if(n != `val`) {
                nums[indexToPut] = n
                indexToPut++
                counter++
            }
        }

        return counter
    }
}

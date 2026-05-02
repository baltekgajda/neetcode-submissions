class Solution {
    fun search(nums: IntArray, target: Int): Int {
        if(nums.size == 1 ) {
            return if(nums[0] == target) 0 else -1
        }

        fun findStartIndex(startIndex: Int, endIndex: Int): Int {
            if(startIndex + 1 == endIndex) {
                return if(nums[startIndex] < nums[endIndex]) {
                    startIndex
                } else {
                    endIndex
                }
            }

            val middleIndex: Int = (endIndex-startIndex) / 2 + startIndex
            return if(nums[middleIndex] > nums[startIndex]) {
                findStartIndex(middleIndex, endIndex)
            } else {
                findStartIndex(startIndex, middleIndex)
            }
        }

        val startIndex = findStartIndex(0, nums.size-1)

        fun getIndexAfterRotation(index: Int): Int {
            if(index == -1) return -1
            return (startIndex+index) % nums.size
        }

        fun findIndex(beg: Int, end: Int): Int {
            val begVal = nums[getIndexAfterRotation(beg)]
            val endVal = nums[getIndexAfterRotation(end)]

            if(target == begVal) {
                return beg
            }
            
            if(target == endVal) {
                return end
            }


            if(end-beg == 1) {
                return -1
            }

            val mid = (end-beg) / 2 + beg
            val midVal = nums[getIndexAfterRotation(mid)]

            return if(target <= midVal) {
                findIndex(beg, mid)
            } else {
                findIndex(mid, end)
            }
        }

        return getIndexAfterRotation(findIndex(0, nums.size-1))
    }
}

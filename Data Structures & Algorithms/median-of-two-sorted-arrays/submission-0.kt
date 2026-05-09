class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        // two pointers
        // we merge two arrays until we merged the middle 
        // we take one or two items and get the median

        val limit = (nums1.size + nums2.size) / 2
        val mergedList = mutableListOf<Int>()
        var i = 0
        var j = 0
        while(mergedList.size <= limit) {
            if(i == nums1.size) {
                mergedList.add(nums2[j])
                j++
                continue
            }

            if(j == nums2.size) {
                mergedList.add(nums1[i])
                i++
                continue
            }

            val first = nums1[i]
            val second = nums2[j]

            if(first < second) {
                mergedList.add(first)
                i++
            } else {
                mergedList.add(second)
                j++
            }
        }

        val index = (nums1.size + nums2.size) / 2
        return if((nums1.size + nums2.size) % 2 == 0) {
            (mergedList[index] + mergedList.getOrElse(index - 1) {0}) / 2.0
        } else {
            mergedList[index].toDouble()
        }
    }
}

class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        var n1 = m - 1
        var n2 = n - 1
        for(i in nums1.size -1 downTo 0) {
            val n1Value = nums1.getOrNull(n1) ?: Int.MIN_VALUE
            val n2Value = nums2.getOrNull(n2) ?: Int.MIN_VALUE

            nums1[i] = if(n2Value > n1Value) {
                n2--
                n2Value  
            } else {
                n1--
                n1Value  
            }
        }
    }
}

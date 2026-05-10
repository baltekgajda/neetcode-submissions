class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        //O(n+m) sulution, super hard to understand by myself
        var A = nums1
        var B = nums2
        val total = A.size + B.size
        val half = (total + 1) / 2 //<- we are looking for this element in sorted array

        if(B.size < A.size) {
            A = nums2   //we want A to be smaller
            B = nums1   // we want B to be larger
        }

        //first we do binary search on A as it is smaller - optimazation, not needed, we could choose whichever
        var l = 0 // <- left pointer of binary search, inclusive
        var r = A.size // <- right pointer, exclusive
        while(l <= r) {
            val i = (l + r) / 2 // middle of array A
            val j = half - i // pointer of array B, because we already have i elements in array A, we only need half-i from B

            //now we calculate values to determine if median is inside <0, i> for A and <0, j> in B
            // left values are included, right values are not
            val Aleft = if (i > 0) A[i - 1] else Int.MIN_VALUE
            val Aright = if (i < A.size) A[i] else Int.MAX_VALUE
            val Bleft = if (j > 0) B[j - 1] else Int.MIN_VALUE
            val Bright = if (j < B.size) B[j] else Int.MAX_VALUE

            //we check whether partitions are correct
            if(Aleft <= Bright && Bleft <= Aright) {
                //odd total
                return if (total % 2 != 0) {
                    kotlin.math.max(Aleft.toDouble(), Bleft.toDouble())
                } else {
                    // last element of left partitions + first element of second partion (smaller one as it is sorted)
                    (kotlin.math.max(Aleft.toDouble(), Bleft.toDouble()) + kotlin.math.min(Aright.toDouble(), Bright.toDouble())) / 2.0
                }
            } else if (Aleft > Bright) {
                // we move to middle of A so we decrease right because we have too many elements 
                r = i - 1
            } else {
                // we increase the right as we have two few elements in A
                l = i + 1
            }
        }

        return -1.0
    }
}

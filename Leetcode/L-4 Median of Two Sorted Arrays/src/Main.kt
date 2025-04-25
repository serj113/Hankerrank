fun main() {
    println(
        Solution()
            .findMedianSortedArrays(
                nums1 = intArrayOf(1,3),
                nums2 = intArrayOf(2),
            )
    )
}

class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val length = nums1.size + nums2.size
        val all = IntArray(length)
        var x = 0
        var y = 0
        for (i in all.indices) {
            if (x <= nums1.lastIndex && (y > nums2.lastIndex || nums2[y] > nums1[x])) {
                all[i] = nums1[x]
                x++
            } else {
                all[i] = nums2[y]
                y++
            }
        }

        return if (length % 2 == 1) {
            all[length / 2].toDouble()
        } else {
            val half = length / 2
            (all[half - 1] + all[half]) / 2.toDouble()
        }
    }
}
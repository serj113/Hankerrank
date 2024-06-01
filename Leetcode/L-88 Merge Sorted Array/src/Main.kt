fun main() {
    val nums1 = intArrayOf(
        -1,0,0,3,3,3,0,0,0
    )
    val m = 6
    val nums2 = intArrayOf(
        1,2,2
    )
    val n = 3
    Solution().merge(nums1, m, nums2, n)
    println("result $nums1")
}

class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        if (nums2.isEmpty()) return
        val first = nums1.copyOf()
        val second = nums2.copyOf()
        var x = 0
        var y = 0
        for (i in 0..<(m+n)) {
            val secondValue = second.getOrNull(y) ?: Int.MAX_VALUE
            if (first[x] < secondValue && x < m) {
                nums1[i] = first[x]
                x++
            } else {
                nums1[i] = second[y]
                y++
            }
        }
    }
}
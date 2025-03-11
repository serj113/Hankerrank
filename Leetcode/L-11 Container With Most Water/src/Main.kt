fun main() {
    println(
        Solution()
            .maxArea(
                height = intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)
            )
    )
}

class Solution {
    fun maxArea(height: IntArray): Int {
        var max = Int.MIN_VALUE
        var left = 0
        var right = height.lastIndex
        while (left < right) {
            max = maxOf(max, minOf(height[left], height[right]) * (right - left))
            if (height[left] < height[right]) {
                left++
            } else right--
        }

        return max
    }
}
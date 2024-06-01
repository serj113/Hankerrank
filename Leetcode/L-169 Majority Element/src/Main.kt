fun main() {
    val nums = intArrayOf(
        3,2,3
    )
    val result = Solution().majorityElement(
        nums = nums,
    )
    println("Result $result")
}

class Solution {
    fun majorityElement(nums: IntArray): Int {
        var count = 0
        var current = 0
        nums.forEach { value ->
            when {
                count == 0 -> {
                    current = value
                    count++
                }

                current == value -> count++

                else -> count--
            }
        }
        return current
    }
}
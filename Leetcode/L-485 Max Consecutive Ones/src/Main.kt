fun main() {
    println(
        Solution()
            .findMaxConsecutiveOnes(
                nums = intArrayOf(
                    1, 0, 1, 1, 0, 1
                ),
            )
    )
}

class Solution {
    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        var max = 0
        var cur = 0
        nums.forEach { num ->
            if (num == 1) {
                cur++
            }
            max = Math.max(max, cur)
            if (num == 0) {
                cur = 0
            }
        }

        return max
    }
}
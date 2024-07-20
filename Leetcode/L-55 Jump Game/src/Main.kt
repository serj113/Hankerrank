import kotlin.math.max

fun main() {
    val result = Solution().canJump(
        intArrayOf(
            2,0,0
        )
    )
    println("Result $result")
}

class Solution {
    fun canJump(nums: IntArray): Boolean {
        var maxJump = 0
        for (i in nums.indices) {
            if (maxJump < i || maxJump >= nums.size) {
                break
            }
            maxJump = max(maxJump, nums[i] + i)
        }
        return maxJump >= nums.size - 1
    }
}
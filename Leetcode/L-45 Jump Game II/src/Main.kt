import kotlin.math.max

fun main() {
    val result = Solution().jump(
        nums = intArrayOf(
            2,3,1
        ),
    )
    println("Result $result")
}

class Solution {
    fun jump(nums: IntArray): Int {
        var count = 0
        var i = 0
        while (i < nums.size - 1) {
            var maxI = i
            var maxJump = 0
            count++
            if (nums[i] + i >= nums.size - 1) {
                break
            }
            for (j in i..nums[i] + i) {
                val cur = nums[j] + j
                if (cur > maxJump) {
                    maxJump = cur
                    maxI = j
                }
            }
            i = maxI
        }
        return count
    }
}
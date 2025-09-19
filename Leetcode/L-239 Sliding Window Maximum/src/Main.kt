import java.util.*

fun main() {
    val nums = intArrayOf(1, 3, -1, -3, 5, 3, 6, 7)
    val k = 3
    println(
        Solution()
            .maxSlidingWindow(nums, k)
            .toList()
    )  // Output: [3, 3, 5, 5, 6, 7]
}

class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val deque: Deque<Int> = LinkedList()
        val result = mutableListOf<Int>()

        for (i in nums.indices) {
            // Remove elements that are out of the current window
            if (deque.isNotEmpty() && deque.first() < i - k + 1) {
                deque.removeFirst()
            }

            // Remove elements smaller than the current one (not useful)
            while (deque.isNotEmpty() && nums[deque.last()] < nums[i]) {
                deque.removeLast()
            }

            deque.addLast(i)

            // Start adding to the result after first k elements
            if (i >= k - 1) {
                result.add(nums[deque.first()])
            }
        }

        return result.toIntArray()
    }
}
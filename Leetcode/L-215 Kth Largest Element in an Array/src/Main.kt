import java.util.PriorityQueue

fun main() {
    println(
        Solution()
            .findKthLargest(
                intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6),
                4
            )
    )
}

class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val queue = PriorityQueue<Int>(compareByDescending { it })
        nums.forEach { num ->
            queue.offer(num)
            if (queue.size > k) {
                queue.poll()
            }
        }

        return queue.peek()
    }
}
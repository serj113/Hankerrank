import java.util.PriorityQueue
import kotlin.math.abs

fun main() {
//    longestConsecutive(
//        nums = listOf(100, 4, 200, 1, 3, 2),
//    ).forEach {
//        print("$it ")
//    }
    println(
        longestSubarray(
            nums = intArrayOf(1, 2, 2, 3, 3, 3)
        )
    )
}

fun longestConsecutive(nums: List<Int>): List<Int> {
    val queue = PriorityQueue<Int>()
    nums.forEach {
        queue.offer(it)
    }
    var max = 1
    var count = 1
    var prev = queue.poll()
    var temp = mutableListOf(prev)
    var result = temp.toList()
    do {
        if (prev + 1 == queue.peek()) {
            count++
            temp.add(queue.peek())
        } else {
            temp = mutableListOf(queue.peek())
            count = 1
        }

        if (count > max) {
            max = count
            result = temp
        }
        max = Math.max(max, count)
        prev = queue.poll()
    } while (queue.isNotEmpty())

    return result
}

fun longestSubarray(nums: IntArray): Int {
    if (nums.size <= 1) return nums.size
    var count = 1
    var prev = Pair(nums.first(), 0)
    var cur = prev
    var result = 1
    var i = 1
    while (i <= nums.lastIndex) {
        if ((abs(prev.first - nums[i]) <= 1) && (abs(cur.first - nums[i]) <= 1)) {
            if (cur.first != nums[i]) {
                prev = cur
                cur = Pair(nums[i], i)
            }
            count++
        } else {
            prev = cur
            cur = Pair(nums[i], i)
            count = i - prev.second + 1
        }
        i++
        result = maxOf(result, count)
    }

    return result
}
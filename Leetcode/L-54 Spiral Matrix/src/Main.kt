import java.util.*

//fun main() {
//    Solution()
//        .spiralOrder(
//            matrix = arrayOf(
//                intArrayOf(
//                    1, 2, 3, 4
//                ),
//                intArrayOf(
//                    5, 6, 7, 8
//                ),
//                intArrayOf(
//                    9, 10, 11, 12
//                ),
//                intArrayOf(
//                    13, 14, 15, 16
//                ),
//                intArrayOf(
//                    17, 18, 19, 20
//                ),
//                intArrayOf(
//                    21, 22, 23, 24
//                ),
//            )
//        )
//        .forEach {
//            print("$it, ")
//        }
//}

class Solution {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        var remain = matrix.size * matrix.first().size
        val checker = Array(matrix.size) {
            hashSetOf<Int>()
        }
        val result = mutableListOf<Int>()
        var i = 0
        var j = 0
        var iChanger = 0
        var jChanger = 1
        while (remain > 0) {
            if (matrix[i][j] == 17) {
                println(matrix[i][j])
            }
            remain--
            checker[i].add(j)
            result.add(matrix[i][j])
            when {
                jChanger > 0 && ((j + 1) > matrix[i].lastIndex || checker[i].contains(j + 1)) -> {
                    iChanger = 1
                    jChanger = 0
                }

                jChanger < 0 && ((j - 1) < 0 || checker[i].contains(j - 1)) -> {
                    iChanger = -1
                    jChanger = 0
                }

                iChanger > 0 && ((i + 1) > matrix.lastIndex || checker[i + 1].contains(j)) -> {
                    iChanger = 0
                    jChanger = -1
                }

                iChanger < 0 && ((i - 1) < 0 || checker[i - 1].contains(j)) -> {
                    iChanger = 0
                    jChanger = 1
                }
            }
            i += iChanger
            j += jChanger
        }

        return result
    }
}

fun maxProfit(views: IntArray, durations: IntArray, k: Int): Int {
    // Step 1: Pair (views, duration) and sort by views in descending order
    val pairs = views.zip(durations).sortedByDescending { it.first }

//    val minHeap = PriorityQueue<Int>() // Min-heap for storing k durations
    var sumDurations = 0  // Track sum of k durations
    var maxProfit = 0  // Store max profit
    var prevDurations = LinkedList<Int>() // Min-heap for storing k durations

    for ((view, duration) in pairs) {
//        minHeap.add(duration)
        prevDurations.add(duration)
        sumDurations += duration

        // If heap size exceeds k, remove smallest duration
//        if (minHeap.size > k) {
//            sumDurations -= minHeap.poll()
//        }
        if (prevDurations.size > k) {
            sumDurations -= prevDurations.poll()
        }

        // Only calculate profit when we have exactly k elements
//        if (minHeap.size == k) {
//            maxProfit = maxOf(maxProfit, view * sumDurations)
//        }
        if (prevDurations.size == k) {
            maxProfit = maxOf(maxProfit, view * sumDurations)
        }
    }

    return maxProfit
}

// Example usage:
fun main() {
//    val views = intArrayOf(2, 1, 3, 4)
//    val durations = intArrayOf(1, 3, 3, 2)
    val views = intArrayOf(9, 9, 1, 1)
    val durations = intArrayOf(4, 4, 10, 10)
    val k = 2
    println(maxProfit(views, durations, k)) // Output: 12
}
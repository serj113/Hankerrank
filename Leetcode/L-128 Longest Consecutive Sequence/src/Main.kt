import java.util.PriorityQueue
import java.util.Stack

fun main() {
//    println(
//        Solution()
//            .longestConsecutive(
//                nums = intArrayOf(100, 4, 200, 1, 3, 2),
//            )
//    )

//    println(
//        isValid(")")
//    )

    println(
        findMissingPositive(intArrayOf(3, 4, -1, 1))
    )
}

class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        if (nums.isEmpty()) return 0

        var max = 0
        val set = nums.toSet()

        for (num in set) { // when iterate using nums it will run slower
            var count = 1
            if (!set.contains(num - 1)) {
                var temp = num + 1
                while (set.contains(temp)) {
                    temp++
                    count++
                }
                max = maxOf(count, max)
            }
        }

        return max
    }
}

fun isValid(s: String): Boolean {
    val stack = Stack<Char>()
    s.forEach { c ->
        if (c == '(' || c == '[' || c == '{') {
            stack.push(c)
        } else if (c == ')' || c == ']' || c == '}') {
            if (stack.isEmpty()) return false
            val temp = stack.pop()
            if ((c == ')' && temp != '(') || (c == ']' && temp != '[') || (c == '}' && temp != '{')) {
                return false
            }
        }

    }
    return true
}

//fun isValid(s: String): Boolean {
//    val stack = Stack<Char>()
//    val matchingBrackets = mapOf(')' to '(', ']' to '[', '}' to '{')
//
//    for (c in s) {
//        if (c in matchingBrackets.values) { // If it's an opening bracket
//            stack.push(c)
//        } else if (c in matchingBrackets.keys) { // If it's a closing bracket
//            if (stack.isEmpty() || stack.pop() != matchingBrackets[c]) {
//                return false
//            }
//        }
//    }
//
//    return stack.isEmpty() // Ensure no unmatched opening brackets
//}

fun findMissingPositive(nums: IntArray): Int {
    val numsSet = nums.toSet()
    val queue = PriorityQueue<Int>()
    for (num in numsSet) {
        if (numsSet.contains(num + 1)) {
            continue
        }
        if (num + 1 != 0) {
            queue.offer(num + 1)
        }
    }

    return queue.poll()
}
fun main() {
//    println(
//        Solution()
//            .firstMissingPositive(
//                nums = intArrayOf(1, 2, 0),
//            )
//    )

    println(
        longestEvenSubarray(
            nums = intArrayOf(1, 2, 4, 6, 1, 2, 8, 10, 3, 4),
        )
    )
}

class Solution {
    fun firstMissingPositive(nums: IntArray): Int {
        val numsSet = nums.toSet()
        for (i in 1..numsSet.size) {
            if (numsSet.contains(i)) {
                continue
            }
            return i
        }
        return numsSet.size + 1
    }
}

fun longestEvenSubarray(nums: IntArray): Int {
    if (nums.isEmpty()) return 0
    var max = 0
    var count = 0
    for (num in nums) {
        if (num % 2 == 0) {
            count++
        } else {
            count = 0
        }
        max = maxOf(max, count)
    }

    return max
}
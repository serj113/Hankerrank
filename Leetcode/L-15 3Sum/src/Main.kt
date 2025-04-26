import kotlin.math.max
import kotlin.math.min

fun main() {
    Solution()
        .threeSum(
            intArrayOf()
        )
        .forEach { line ->
            line.forEach { item ->
                print("$item ")
            }
            println()
        }
}

class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val set = hashSetOf<Int>()
        val setResult = hashSetOf<Pair<Int, Int>>()
        val 

        nums.forEach {
            set.add(it)
        }

        val list = set.toList()
        for (i in 0..<list.lastIndex) {
            for (j in (i + 1)..list.lastIndex) {
                if (set.contains(list[i] + list[j])) {
                    val first = min(list[i], list[j])
                    val second = max(list[i], list[j])
                }
            }
        }
    }
}
fun main() {
    Solution()
        .summaryRanges(
            nums = intArrayOf(
                0, 2, 3, 4, 6, 8, 9,
            )
        )
        .forEach {
            println(it)
        }
}

class Solution {
    fun summaryRanges(nums: IntArray): List<String> {
        val result = mutableListOf<String>()
        var start: Int? = null
        nums.forEachIndexed { index, num ->
            if (index == nums.lastIndex || num + 1 != nums[index + 1]) {
                start?.let {
                    result.add(
                        "$it->$num"
                    )
                } ?: run {
                    result.add(
                        num.toString()
                    )
                }
                start = null
            } else if (start == null) {
                start = num
            }
        }

        return result
    }
}
fun main() {
    Solution()
        .permute(
            intArrayOf(0, 1)
        )
        .forEach { list ->
            list.forEach {
                print("$it ")
            }
            println()
        }
}

class Solution {
    fun permute(nums: IntArray): List<List<Int>> {
        if (nums.isEmpty()) return listOf(listOf())

        val child = when (nums.size) {
            1 -> permute(intArrayOf())

            else -> permute(nums.copyOfRange(1, nums.size))
        }

        val result = mutableListOf<List<Int>>()

        child.forEach { list ->
            for (i in 0..list.size) {
                val item = list.toMutableList().apply {
                    add(i, nums.first())
                }
                result.add(item)
            }
        }

        return result
    }
}
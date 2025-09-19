fun main() {
    Solution()
        .permuteUnique(
            intArrayOf(1, 1, 2)
        )
        .forEach { list ->
            list.forEach {
                print("$it ")
            }
            println()
        }
}

class Solution {
    val set = hashSetOf<List<Int>>()
    fun permuteUnique(nums: IntArray): List<List<Int>> {
        permute(nums)

        return set.toList()
    }

    private fun permute(nums: IntArray) {
        if (nums.isEmpty()) {
            set.add(listOf())
            return
        }

        if (nums.size == 1) {
            permuteUnique(intArrayOf())
        } else permuteUnique(nums.copyOfRange(1, nums.size))

        set.toList().forEach { list ->
            for (i in 0..list.size) {
                val item = list.toMutableList().apply {
                    add(i, nums.first())
                }
                set.add(item)
            }
            set.remove(list)
        }
    }
}
fun main() {
    println(
        Solution()
            .findDisappearedNumbers(
                intArrayOf(
                    1, 1
                )
            )
    )
}

class Solution {
    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        val result = IntArray(nums.size) { 1 }
        nums.forEach { num ->
            result[num - 1] = 0
        }

        val temp = mutableListOf<Int>()
        result.forEachIndexed { index, i ->
            if (i == 1) {
                temp.add(index + 1)
            }
        }

        return temp
    }
}
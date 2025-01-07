fun main() {
    println(
        Solution()
            .searchInsert(
                nums = intArrayOf(1, 3, 5, 6),
                target = 7,
            )
    )
}

class Solution {
    fun searchInsert(nums: IntArray, target: Int): Int {
        return searchIndex(0, nums, target)
    }

    private fun searchIndex(index: Int, nums: IntArray, target: Int): Int {
        return if (target == nums[index] || target < nums[index]) {
            index
        } else if (index == nums.lastIndex) {
            index + 1
        } else {
            searchIndex(index + 1, nums, target)
        }
    }
}
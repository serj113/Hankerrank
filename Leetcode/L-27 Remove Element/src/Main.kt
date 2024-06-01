fun main() {
    val nums = intArrayOf(
        0,1,2,2,3,0,4,2,
    )
    val result = Solution().removeElement(
        nums = nums,
        item = 2,
    )
    println("Result $result")
}

class Solution {
    fun removeElement(nums: IntArray, item: Int): Int {
        var j = 0
        var count = 0
        for (i in nums.indices) {
            if (nums[i] != item) {
                nums[j] = nums[i]
                j++
            } else {
                count++
            }
        }
        return nums.size - count
    }
}
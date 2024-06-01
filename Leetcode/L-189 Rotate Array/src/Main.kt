fun main() {
    val nums = intArrayOf(
//        1,2,3,4,5,6,7
        0,1,2,3
    )
    Solution().rotate(
        nums = nums,
        k = 1,
    )
    println("Hello World!")
}

class Solution {
    fun rotate(nums: IntArray, k: Int): Unit {
        var rotation = k % nums.size
        if (rotation == 0) return
        val temp = IntArray(nums.size)
        for (i in nums.indices) {
            temp[i] = nums[i]
            if (i > (rotation-1)) {
                nums[i] = temp[i-rotation]
            } else {
                nums[i] = nums[nums.size - rotation + i]
            }
        }
    }
}
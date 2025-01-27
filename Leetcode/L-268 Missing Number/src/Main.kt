fun main() {
    println(
        Solution()
            .missingNumber(
                nums = intArrayOf(
                    9,6,4,2,3,5,7,0,1
                ),
            )
    )
}

class Solution {
    fun missingNumber(nums: IntArray): Int {
        var sum = 0
        for (i in 0..nums.size) {
            if (i <= nums.lastIndex) {
                sum -= nums[i]
            }
            sum += i
        }
        return sum
    }
}
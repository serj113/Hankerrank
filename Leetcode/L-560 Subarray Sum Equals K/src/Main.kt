fun main() {
    println(
        Solution()
            .subarraySum(
                nums = intArrayOf(1, 2, 3),
                k = 3
            )
    )
}

class Solution {
    fun subarraySum(nums: IntArray, k: Int): Int {
        var total = 0
        var max = 0
        var left = 0
        for (i in nums.indices) {
            total += nums[i]
            while (total > k && left <= i) {
                total -= nums[left]
                left++
            }
            max = maxOf(max, i - left + 1)
        }
        return max
    }
}
fun main() {
    val nums = intArrayOf(
        0,0,1,1,1,2,2,3,3,4,
    )
    val result = Solution().removeDuplicates(
        nums = nums,
    )
    println("Result $result")
}

class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        val hash = hashSetOf<Int>()
        var i = 0
        var j = 0
        while (i < nums.size) {
            val temp = nums[i]
            nums[j] = temp
            j++
            hash.add(temp)
            while (i < nums.size && hash.contains(nums[i])) {
                i++
            }
        }
        return hash.size
    }
}

fun main() {
    val nums = intArrayOf(
        1,1,1,2,2,3
    )
    val result = Solution().removeDuplicates(
        nums = nums,
    )
    println("Result $result")
}

class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var i = 0
        val hash = hashSetOf<Int>()
        var count = 0

        while (i < nums.size) {
            val temp = nums[i]
            val start = i
            hash.add(temp)
            while (i < nums.size && hash.contains(nums[i])) {
                i++
            }
            val j = Math.min(i-start, 2)
            for (x in count..<count + j) {
                nums[x] = temp
            }
            count += j
        }

        return count
    }
}
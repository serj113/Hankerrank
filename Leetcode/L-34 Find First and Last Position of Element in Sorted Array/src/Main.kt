fun main() {
    Solution()
        .searchRange(intArrayOf(5,7,7,8,8,10), 8)
        .forEach {
            print("$it ")
        }
}

class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        var start = -1
        var end = -1

        nums.forEachIndexed { index, num ->
            if (num == target) {
                if (start == -1) {
                    start = index
                }
                end = index
            }
        }

        return intArrayOf(start, end)
    }
}
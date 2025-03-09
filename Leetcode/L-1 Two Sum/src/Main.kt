fun main() {
    val list = listOf(1, 2, 3)
    list.getOrNull()
//    println(
//        Solution().twoSum(
//            nums = intArrayOf(
//                -3, 4, 3, 90
//            ),
//            target = 0
//        ).toString()
//    )
}

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = hashMapOf<Int, Int>()
        var result = intArrayOf(0, 0)
        for (i in 0..nums.lastIndex) {
            if (map.containsKey(nums[i])) {
                result = intArrayOf(map[nums[i]] ?: 0, i)
                break
            } else {
                map[target - nums[i]] = i
            }
        }

        return result
    }
}
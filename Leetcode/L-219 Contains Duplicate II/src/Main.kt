fun main() {
    println(
        Solution().containsNearbyDuplicate(
            nums = intArrayOf(
                1, 0, 1, 1
            ),
            k = 1,
        )
    )
}

class Solution {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val map = hashMapOf<Int, Int>()
        nums.forEachIndexed { index, i ->
            if (map.containsKey(i) && index - (map[i] ?: 0) <= k) {
                return true
            } else {
                map[i] = index
            }
        }

        return false
    }
}
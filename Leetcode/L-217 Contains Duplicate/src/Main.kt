fun main() {

}

class Solution {
    fun containsDuplicate(nums: IntArray): Boolean {
        val set = hashSetOf<Int>()
        nums.forEach { num ->
            if (set.contains(num)) {
                return true
            } else {
                set.add(num)
            }
        }

        return false
    }
}
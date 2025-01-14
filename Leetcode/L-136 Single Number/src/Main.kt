fun main() {

}

class Solution {
    fun singleNumber(nums: IntArray): Int {
        val set = hashSetOf<Int>()
        nums.forEach { num ->
            if (set.contains(num)) {
                set.remove(num)
            } else {
                set.add(num)
            }
        }
        return set.first()
    }
}
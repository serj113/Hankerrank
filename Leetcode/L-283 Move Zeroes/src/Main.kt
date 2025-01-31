fun main() {

}

class Solution {
    fun moveZeroes(nums: IntArray): Unit {
        val copy = nums.copyOf()
        var counter = 0
        var reverseCounter = nums.lastIndex
        copy.forEach { num ->
            if (num == 0) {
                nums[reverseCounter] = 0
                reverseCounter--
            } else {
                nums[counter] = num
                counter++
            }
        }
    }
}
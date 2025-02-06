fun main() {

}

class NumArray(private val nums: IntArray) {

    fun sumRange(left: Int, right: Int): Int {
        var sum = 0
        for (i in left..right) {
            sum += nums[i]
        }

        return sum
    }
}
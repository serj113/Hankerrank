fun main() {
    println(
        Solution()
            .reverse(123)
    )
}

class Solution {
    fun reverse(x: Int): Int {
        var current = x
        var result = 0L

        while (current > 0 || current < 0) {
            result = result * 10 + current % 10
            current /= 10
        }

        return if (result < Int.MIN_VALUE || result > Int.MAX_VALUE) {
            0
        } else result.toInt()
    }
}
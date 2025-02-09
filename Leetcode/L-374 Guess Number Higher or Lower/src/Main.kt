fun main() {
    val solution = Solution(6)
    println(
        solution.guessNumber(10)
    )
}

class Solution(
    private val pick: Int
) {

    fun guess(n: Int): Int {
        return if (n == pick) {
            0
        } else if (n > pick) {
            -1
        } else 1
    }

    fun guessNumber(n: Int): Int {
        var l = 1
        var r = n
        while (l < r) {
            val m = l + (r - l) / 2
            if (guess(m) <= 0) {
                r = m
            } else {
                l = m + 1
            }
        }

        return l
    }
}
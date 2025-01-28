fun main() {
    println(
        Solution()
            .isPowerOfFour(1)
    )
}

class Solution {
    fun isPowerOfFour(n: Int): Boolean {
        return if (n == 1) {
            true
        } else if (n % 4 > 0 || n <= 0) {
            false
        } else isPowerOfFour(n / 4)
    }
}
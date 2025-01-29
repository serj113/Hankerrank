fun main() {
    println(
        Solution()
            .isPowerOfThree(45)
    )
}

class Solution {
    fun isPowerOfThree(n: Int): Boolean {
        return if (n == 1 || n == 3) {
            true
        } else if (n % 3 > 0 || n < 3) {
            false
        } else isPowerOfThree(n / 3)
    }
}
fun main() {
    println(
        Solution()
            .isPowerOfTwo(3)
    )
}

class Solution {
    fun isPowerOfTwo(n: Int): Boolean {
        if (n == 1 || n == 2) return true
        if (n == 0 || n % 2 == 1) return false
        return isPowerOfTwo(n/2)
    }
}
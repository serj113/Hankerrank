fun main() {
    println(
        Solution()
            .climbStairs(
                n = 3,
            )
    )
}

class Solution {
    companion object {
        val map = hashMapOf<Int, Int>()
    }
    fun climbStairs(n: Int): Int {
        return if (n <= 2) {
            n
        } else {
            val result = map[n] ?: run {
                climbStairs(n - 1) + climbStairs(n - 2)
            }
            map[n] = result
            result
        }
    }
}
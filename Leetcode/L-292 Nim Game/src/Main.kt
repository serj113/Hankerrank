fun main() {
    println(
        Solution()
            .canWinNim(6)
    )
}

class Solution {
    fun canWinNim(n: Int): Boolean {
        return n % 4 != 0
    }
}
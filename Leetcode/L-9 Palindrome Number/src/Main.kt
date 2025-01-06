fun main() {
    println(
        Solution().isPalindrome(11)
    )
}

class Solution {
    fun isPalindrome(x: Int): Boolean {
        if (x < 0) return false
        val text = x.toString()
        for (i in 0..((text.length - 1) / 2)) {
            if (text[i] != text[(text.length - 1) - i]) {
                return false
            }
        }

        return true
    }
}
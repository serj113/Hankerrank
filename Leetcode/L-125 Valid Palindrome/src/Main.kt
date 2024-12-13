fun main() {
    println(
        Solution().isPalindrome(
            s = "A man, a plan, a canal: Panama"
        )
    )
}

class Solution {
    fun isPalindrome(s: String): Boolean {
        var same = true
        var i = 0
        var j = s.lastIndex
        while (i <= j && same) {
            while (i <= j && !s[i].isLetterOrDigit()) {
                i++
            }
            while (i <= j && !s[j].isLetterOrDigit()) {
                j--
            }
            if (i > j) {
                break
            }
            same = s[i].uppercaseChar() == s[j].uppercaseChar()

            i++
            j--
        }

        return same
    }
}
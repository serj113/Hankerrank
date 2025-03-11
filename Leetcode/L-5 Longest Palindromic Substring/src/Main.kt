fun main() {

}

class Solution {
    fun longestPalindrome(s: String): String {
        var result = ""
        var i = 0
        var j = s.lastIndex
        val mid = j / 2.toDouble()
        while (i < j) {

        }
    }

    private fun isPalindrome(s: String, start: Int, end: Int): Boolean {
        val length = start - end + 1
        val mid = if (length % 2 == 1) {
            length / 2
        } else (length / 2) - 1
        var i = start
        var j = end
        while (i < j) {
            if (s[i] != s[j]) {
                return false
            }
            i++
            j++
        }
        return true
    }
}
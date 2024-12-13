fun main() {
    println(
        Solution().isSubsequence(
            s = "b",
            t = "abc",
        )
    )
}

class Solution {
    fun isSubsequence(s: String, t: String): Boolean {
        var i = 0
        var j = 0
        while (i <= s.lastIndex) {
            if (j == t.length) {
                break
            }
            if (s[i] == t[j]) {
                i++
                j++
            }
            while (i <= s.lastIndex && j <= t.lastIndex && s[i] != t[j]) {
                j++
            }
        }

        return i == s.length
    }
}
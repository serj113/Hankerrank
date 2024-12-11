fun main() {
    println(Solution().lengthOfLastWord("a"))
}

class Solution {
    fun lengthOfLastWord(s: String): Int {
        var last = 0
        var count = 0
        var counting = false
        var i = s.lastIndex
        while (i >= last) {
            if (s[i] != ' ' && !counting) {
                counting = true
            } else if (s[i] == ' ' && counting) {
                counting = false
                last = i
            }
            if (s[i] != ' ' && counting) {
                count++
            }
            i--
        }

        return count
    }
}
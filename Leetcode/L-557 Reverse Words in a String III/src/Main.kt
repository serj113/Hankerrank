fun main() {
    println(
        Solution()
            .reverseWords("Let's take LeetCode contest")
    )
}

class Solution {
    fun reverseWords(s: String): String {
        val words = s.split(" ")
        var result = ""

        words.forEachIndexed { index, word ->
            result += reverse(word)

            if (index != words.lastIndex) {
                result += " "
            }
        }

        return result
    }

    private fun reverse(s: String): String {
        var result = ""
        for (i in s.lastIndex.downTo(0)) {
            result += s[i]
        }

        return result
    }
}
fun main() {
    println(
        Solution()
            .reverseVowels("leetcode")
    )
}

class Solution {
    private val vowels = hashSetOf(
        'a', 'A', 'i', 'I', 'u', 'U', 'e', 'E', 'o', 'O'
    )

    fun reverseVowels(s: String): String {
        var result = s
        var start = 0
        var end = result.lastIndex
        while (start < end) {
            while (start <= result.lastIndex && !vowels.contains(result[start])) {
                start++
            }
            while (end >= 0 && !vowels.contains(result[end])) {
                end--
            }
            if (start < end) {
                val temp = result[end]
                result = result.replaceRange(end..end, result[start].toString())
                result = result.replaceRange(start..start, temp.toString())

                start++
                end--
            }
        }

        return result
    }
}
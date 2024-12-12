fun main() {
    println(
        Solution().longestCommonPrefix(
            strs = arrayOf(
                "flower", "flow", "flight",
            )
        )
    )
    println(
        Solution().longestCommonPrefix(
            strs = arrayOf(
                "dog", "racecar", "car",
            )
        )
    )
    println(
        Solution().longestCommonPrefix(
            strs = arrayOf(
                "a",
            )
        )
    )
}

class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        var processing = true
        var result = ""
        var i = 0
        while (processing) {
            val temp = strs.first().getOrNull(i) ?: Char.MIN_VALUE
            if (temp == Char.MIN_VALUE) {
                break
            }
            for (j in 0..strs.lastIndex) {
                if (i > strs[j].lastIndex || temp != strs[j][i]) {
                    processing = false
                    break
                }
                if (j == strs.lastIndex) {
                    result += temp
                }
            }
            i++
        }

        return result
    }
}
fun main() {
    println(
        Solution().strStr(
            haystack = "mississippi",
            needle = "issip",
        )
    )
}

class Solution {
    fun strStr(haystack: String, needle: String): Int {
        var result = -1
        if (needle.length > haystack.length) return result
        var i = 0
        while (i+needle.lastIndex <= haystack.lastIndex) {
            if (haystack.substring(i, i + needle.length) == needle) {
                result = i
                break
            }
            i++
        }

        return result
    }
}
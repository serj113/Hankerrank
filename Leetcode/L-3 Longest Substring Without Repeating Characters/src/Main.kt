fun main() {
    println(
        Solution()
            .lengthOfLongestSubstring("dvdf")
    )
}

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        if (s.isEmpty()) return 0
        if (s.length == 1) return 1

        // Use IntArray instead of HashSet for O(1) lookups
        // Array size 128 covers ASCII characters
        val lastIndex = IntArray('z' - 'a' + 1) { -1 }
        var maxLength = 0
        var start = 0

        for (i in s.indices) {
            val char = s[i] - 'a'
            // If character was seen before and its last position is >= start
            start = maxOf(start, lastIndex[char] + 1)
            // Current window size is (i - start + 1)
            maxLength = maxOf(maxLength, i - start + 1)
            // Store current position of character
            lastIndex[char] = i
        }

        return maxLength
    }
}
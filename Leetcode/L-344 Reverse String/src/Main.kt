fun main() {
    val s = charArrayOf(
        'h', 'e', 'l', 'l', 'o'
    )

    Solution().reverseString(s)

    s.forEach { c ->
        print("{$c} ")
    }
}

class Solution {
    fun reverseString(s: CharArray): Unit {
        val mid = s.lastIndex / 2
        for (i in 0..mid) {
            val temp = s[i]
            s[i] = s[s.lastIndex - i]
            s[s.lastIndex - i] = temp
        }
    }
}
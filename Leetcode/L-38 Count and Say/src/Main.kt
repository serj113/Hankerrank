fun main() {
    println(
        Solution()
            .countAndSay(5)
    )
}

class Solution {
    fun countAndSay(n: Int): String {
        if (n == 1) return "1"

        return works("1", n - 1)
    }

    private fun works(s: String, remain: Int): String {
        if (remain == 0) return s
        var result = ""
        var count = 0
        var previous = s.first()
        s.forEach { c ->
            if (previous == c) {
                count += 1
            } else {
                result += count.toString()
                result += previous
                previous = c
                count = 1
            }
        }
        result += count.toString()
        result += previous

        return works(result, remain - 1)
    }
}
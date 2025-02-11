fun main() {
    println(
        Solution()
            .findTheDifference(
                s = "abcd",
                t = "abcde",
            )
    )
}

class Solution {
    fun findTheDifference(s: String, t: String): Char {
        val counters = IntArray(26) { 0 }
        for (i in t.indices) {
            val index = t[i] - 'a'
            counters[index] += 1
            if (i <= s.lastIndex) {
                val sIndex = s[i] - 'a'
                counters[sIndex] -= 1
            }
        }
        var result = 0
        counters.mapIndexed { index, i ->
            if (i == 1) {
                result = index
            }
        }

        return 'a'.plus(result)
    }
}
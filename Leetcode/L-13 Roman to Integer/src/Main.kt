fun main() {
    println(
        Solution().romanToInt("MCMXCIV")
    )
}

class Solution {

    fun romanToInt(s: String): Int {
        var i = 0
        var result = 0
        while (i <= s.lastIndex) {
            result += when (s[i]) {
                'I' -> {
                    if (i != s.lastIndex && s[i + 1] == 'V') {
                        i++
                        4
                    } else if (i != s.lastIndex && s[i + 1] == 'X') {
                        i++
                        9
                    } else 1
                }

                'V' -> 5

                'X' -> {
                    if (i != s.lastIndex && s[i + 1] == 'L') {
                        i++
                        40
                    } else if (i != s.lastIndex && s[i + 1] == 'C') {
                        i++
                        90
                    } else 10
                }

                'L' -> 50

                'C' -> {
                    if (i != s.lastIndex && s[i + 1] == 'D') {
                        i++
                        400
                    } else if (i != s.lastIndex && s[i + 1] == 'M') {
                        i++
                        900
                    } else 100
                }

                'D' -> 500

                'M' -> 1000

                else -> 0
            }
            i++
        }

        return result
    }
}
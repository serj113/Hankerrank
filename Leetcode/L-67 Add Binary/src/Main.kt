fun main() {
    println(
        Solution()
            .addBinary(
                a = "1010",
                b = "1011",
            )
    )
}

class Solution {
    fun addBinary(a: String, b: String): String {
        var result = ""
        val length = a.lastIndex.coerceAtLeast(b.lastIndex)
        var carry = false

        for (i in 0..length) {
            var temp = 0
            if ((a.lastIndex - i) >= 0) {
                temp += a[a.lastIndex - i].digitToInt()
            }
            if ((b.lastIndex - i) >= 0) {
                temp += b[b.lastIndex - i].digitToInt()
            }
            if (carry) {
                temp += 1
                carry = false
            }
            if (temp > 1) {
                temp -= 2
                carry = true
            }
            result = temp.toString() + result
        }

        if (carry) {
            result = "1$result"
        }

        return result
    }
}
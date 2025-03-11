fun main() {
    println(
        Solution()
            .myAtoi("  0000000000012345678")
    )
}

class Solution {

    fun myAtoi(s: String): Int {
        var sInt = s
        var numbers = ""
        while (sInt.isNotEmpty() && sInt.first() == ' ') {
            sInt = sInt.substring(1, sInt.length)
        }

        var isPositive = true
        if (sInt.isNotEmpty() && (sInt.first() == '-' || sInt.first() == '+')) {
            isPositive = sInt.first() == '+'
            sInt = sInt.substring(1, sInt.length)
        }

        while (sInt.isNotEmpty() && sInt.first() == '0') {
            sInt = sInt.substring(1, sInt.length)
        }

        while (sInt.isNotEmpty() && sInt.first() in ('0'..'9')) {
            numbers += sInt.first()
            sInt = sInt.substring(1, sInt.length)
        }

        val long = if (isPositive && numbers.length > 10) {
            Int.MAX_VALUE.toLong()
        } else if (!isPositive && numbers.length > 10) {
            Int.MIN_VALUE.toLong()
        } else {
            var temp = getLong(numbers)
            if (!isPositive) {
                temp *= -1
            }
            temp
        }

        return if (long > Int.MAX_VALUE) {
            Int.MAX_VALUE
        } else if (long < Int.MIN_VALUE) {
            Int.MIN_VALUE
        } else long.toInt()
    }

    private fun getLong(s: String): Long {
        return try {
            s.toLong()
        } catch (_: Exception) {
            0
        }
    }
}
fun main() {
    Solution()
        .plusOne(
            digits = intArrayOf(8, 9, 9, 9),
        )
        .forEach {
            println(it)
        }
}

class Solution {
    fun plusOne(digits: IntArray): IntArray {
        digits[digits.lastIndex] += 1
        var carry = false
        for (i in digits.lastIndex.downTo(0)) {
            if (carry) {
                digits[i] += 1
                carry = false
            }
            if (digits[i] == 10) {
                digits[i] = 0
                carry = true
            }
        }
        return if (carry) {
            digits.toMutableList().apply {
                add(0, 1)
            }.toIntArray()
        } else digits
    }
}
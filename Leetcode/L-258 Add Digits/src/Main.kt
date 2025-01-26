fun main() {
    println(
        Solution()
            .addDigits(38)
    )
}

class Solution {
    fun addDigits(num: Int): Int {
        return if (num > 9) {
            var temp = num
            var result = 0
            while (temp > 0) {
                val unit = temp % 10
                temp /= 10
                result += unit
            }
            addDigits(result)
        } else num
    }
}
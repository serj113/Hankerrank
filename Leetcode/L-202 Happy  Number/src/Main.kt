import kotlin.math.pow

fun main() {
    println(
        Solution()
            .isHappy(
                n = 1
            )
    )
}

class Solution {
    fun isHappy(n: Int): Boolean {
        val map = hashMapOf<Int, Int>()
        var next = n
        var result = true
        while (true) {
            var remain = next
            var sum = 0
            if (map.containsKey(next)) {
                result = false
                break
            } else {
                while (remain > 0) {
                    sum += (remain % 10).toDouble().pow(2.0).toInt()
                    remain /= 10
                }
                map[next] = sum
                next = sum
            }

            if (next == 1) break
        }

        return result
    }
}
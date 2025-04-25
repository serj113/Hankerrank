fun main() {
//    for (i in 1..10) {
//        val result = Solution()
//            .idealArrays(n = i, maxValue = 5)
//        print("$result, ")
//    }
//    print(
//        Solution()
//            .idealArrays(n = 184, maxValue = 389)
//    )

    val value = 2.5
    val base = 1.3
    val currencies = listOf(
        0.922154,
        16487.682653,
        149.07425,
        10.13729,
        1.0
    )
    val converted = currencies.map {
        value * (it/base)
    }
    println(converted.toString())
}
// 5, 10, 16, 23, 31, 40, 50, 61, 73, 86
// 4, 8, 13, 19, 26, 34, 43, 53, 64, 76
// 3, 5, 7, 9, 11, 13, 15, 17, 19, 21

class Solution {
    companion object {
        private const val MOD = 1000000007
    }

    private var table = arrayOf<IntArray>()

    fun idealArrays(n: Int, maxValue: Int): Int {
        if (n == 1) return maxValue
        table = Array(n) {
            IntArray(maxValue + 1) { 1 }
        }

        for (i in 1..<n) {
            for (j in 1..maxValue) {
                var value = 0
                for (k in 1..j) {
                    if (j % k == 0) {
                        value = (value + table[i - 1][k]) % MOD
                    }
                    table[i][j] = value
                }
            }
        }

        var count = 0
        for (i in 1..table.last().lastIndex) {
            count = (count + table.last()[i]) % MOD
        }

        return count
    }
}
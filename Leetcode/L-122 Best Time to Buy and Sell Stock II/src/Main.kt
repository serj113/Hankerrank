fun main() {
    val result = Solution().maxProfit(
        intArrayOf(
            1,2,3,4,5
        ),
    )
    println("result $result")
}

class Solution {
    fun maxProfit(prices: IntArray): Int {
        var buy = 0
        var count = 0
        var canSell = false
        for (i in prices.indices) {
            val dif = prices[i] - prices[buy]
            if (dif > 0 && canSell) {
                canSell = false
                count += dif
            } else {
                buy = i
            }
            if (!canSell) {
                canSell = true
                buy = i
            }
        }
        return count
    }
}
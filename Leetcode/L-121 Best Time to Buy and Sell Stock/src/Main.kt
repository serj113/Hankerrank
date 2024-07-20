fun main() {
    val result = Solution().maxProfit(
        intArrayOf(
            7,6,4,3,1
        ),
    )
    println("Result $result")
}

class Solution {
    fun maxProfit(prices: IntArray): Int {
        var buy = 0
        var max = 0
        for (i in prices.indices) {
            if (prices[buy] > prices[i]) {
                buy = i
            }
            if (prices[i] - prices[buy] > max) {
                max = prices[i] - prices[buy]
            }
        }
        return max
    }
}
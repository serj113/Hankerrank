import kotlin.math.max

fun main() {
    val result = Solution().maximalNetworkRank(
        5,
        arrayOf(
            intArrayOf(0,1),
            intArrayOf(0,3),
            intArrayOf(1,2),
            intArrayOf(1,3),
//            intArrayOf(2,4),
        )
    )
    println("result $result")
}

class Solution {
    fun maximalNetworkRank(n: Int, roads: Array<IntArray>): Int {
        var maxCounter = 0
        val hashMap = hashMapOf<Int, HashSet<Int>>()
        val list = mutableListOf<Int>()
        roads.forEach { intArray ->
            if (!list.contains(intArray.first())) {
                list.add(intArray.first())
            }
            if (!list.contains(intArray.last())) {
                list.add(intArray.last())
            }
            val firstTempSet = hashMap[intArray.first()] ?: hashSetOf()
            firstTempSet.add(intArray.last())
            hashMap[intArray.first()] = firstTempSet

            val secondTempSet = hashMap[intArray.last()] ?: hashSetOf()
            secondTempSet.add(intArray.first())
            hashMap[intArray.last()] = secondTempSet
        }
        for (i in 0..<(list.size - 1)) {
            for (j in (i + 1)..<list.size) {
                val x = list[i]
                val y = list[j]
                var tempMax = (hashMap[x]?.size ?: 0) + (hashMap[y]?.size ?: 0)
                if (hashMap[x]?.contains(y) == true) {
                    tempMax -= 1
                }
                maxCounter = max(maxCounter, tempMax)
            }
        }
        return maxCounter
    }
}
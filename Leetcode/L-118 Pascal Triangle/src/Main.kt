fun main() {
    val result = Solution().generate(5)

    result.forEach { nums ->
        var line = ""
        nums.forEach { num ->
            line += " $num"
        }
        println(line)
    }
}

class Solution {
    fun generate(numRows: Int): List<List<Int>> {
        val result = mutableListOf(
            mutableListOf(1)
        )
        for (i in 1..<numRows) {
            val row = mutableListOf<Int>()
            for (j in 0..i) {
                val value = if (j == 0 || j == i) {
                    1
                } else {
                    result[i-1][j-1] + result[i-1][j]
                }
                row.add(value)
            }
            result.add(row)
        }

        return result
    }
}
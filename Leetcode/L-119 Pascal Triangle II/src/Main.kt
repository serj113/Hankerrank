fun main() {
    val result = Solution().getRow(3)

    var line = ""
    result.forEach { num ->
        line += " $num"
    }
    println(line)
}

class Solution {
    fun getRow(rowIndex: Int): List<Int> {
        val triangle = mutableListOf(
            mutableListOf(1)
        )
        for (i in 1..rowIndex) {
            val row = mutableListOf<Int>()
            for (j in 0..i) {
                val value = if (j == 0 || j == i) {
                    1
                } else {
                    triangle[i-1][j-1] + triangle[i-1][j]
                }
                row.add(value)
            }
            triangle.add(row)
        }

        return triangle[rowIndex]
    }
}
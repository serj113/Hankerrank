fun main() {
    println(Solution().convert("PAYPALISHIRING", 3))
    // PAHNAPLSIIGYIR
    // PINALSIGYAHRPI
}

class Solution {
    fun convert(s: String, numRows: Int): String {
        if (numRows == 1) return s
        val n = (numRows * 2) - 2
        val lines = hashMapOf<Int, String>()
        s.forEachIndexed { index, c ->
            val mod = index % n
            if (mod > (numRows - 1)) {
                val temp = (numRows - 1) - (mod - (numRows - 1))
                lines[temp] = (lines[temp] ?: "") + c
            } else lines[mod] = (lines[mod] ?: "") + c
        }

        var result = ""
        for (i in 0..<numRows) {
            result += lines[i] ?: ""
        }

        return result
    }
}
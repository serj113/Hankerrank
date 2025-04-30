fun main() {
    Solution()
        .generateParenthesis(3)
        .forEach {
            println(it)
        }
}

class Solution {
    val set = hashSetOf<String>()

    fun generateParenthesis(n: Int): List<String> {
        generate("", n, n)

        return set.toList()
    }

    private fun generate(built: String, open: Int, close: Int) {
        if (open <= 0 && close <= 0) {
            set.add(built)
            return
        }
        if (open < close) {
            generate("$built)", open, close - 1)
        }
        if (open > 0) {
            generate("$built(", open - 1, close)
        }
    }
}
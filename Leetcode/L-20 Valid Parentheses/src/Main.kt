fun main() {
    println(
        Solution()
            .isValid("]")
    )
}

class Solution {

    companion object {
        private const val OPEN_BRACKET = '('
        private const val CLOSE_BRACKET = ')'
        private const val OPEN_CURLY = '{'
        private const val CLOSE_CURLY = '}'
        private const val OPEN_SQUARE = '['
        private const val CLOSE_SQUARE = ']'
    }

    fun isValid(s: String): Boolean {
        val stack = arrayListOf<Char>()
        s.forEach {
            when (it) {
                OPEN_BRACKET, OPEN_CURLY, OPEN_SQUARE -> stack.add(it)

                CLOSE_BRACKET -> {
                    if (stack.isNotEmpty() && stack.last() == OPEN_BRACKET) {
                        stack.removeLast()
                    } else return false
                }

                CLOSE_CURLY -> {
                    if (stack.isNotEmpty() && stack.last() == OPEN_CURLY) {
                        stack.removeLast()
                    } else return false
                }

                CLOSE_SQUARE -> {
                    if (stack.isNotEmpty() && stack.last() == OPEN_SQUARE) {
                        stack.removeLast()
                    } else return false
                }
            }
        }

        return stack.size == 0
    }
}
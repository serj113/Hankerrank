fun main() {
    val result = Solution().letterCombinations(
        "23",
    )
    println("Result $result")
}

class Solution {

    companion object {
        const val TWO = "abc"
        const val THREE = "def"
        const val FOUR = "ghi"
        const val FIVE = "jkl"
        const val SIX = "mno"
        const val SEVEN = "pqrs"
        const val EIGHT = "tuv"
        const val NINE = "wxyz"
    }

    fun letterCombinations(digits: String): List<String> {
        val rest: MutableList<String> = mutableListOf()
        val result = mutableListOf<String>()
        if (digits.length > 1) {
            rest.addAll(letterCombinations(digits.substring(1, digits.length)))
        }
        val current = if (digits.isEmpty()) {
            ""
        } else {
            when (digits.first()) {
                '2' -> TWO
                '3' -> THREE
                '4' -> FOUR
                '5' -> FIVE
                '6' -> SIX
                '7' -> SEVEN
                '8' -> EIGHT
                '9' -> NINE
                else -> ""
            }
        }
        current.forEach { curChar ->
            if (rest.isEmpty()) {
                result.add(curChar.toString())
            } else {
                rest.forEach { restChars ->
                    result.add(curChar + restChars)
                }
            }
        }
        return result
    }
}
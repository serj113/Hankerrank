fun main() {
    Solution()
        .findWords(
            words = arrayOf(
                "Hello", "Alaska", "Dad", "Peace",
            )
        )
        .forEach { word ->
            println(word)
        }
}

class Solution {

    companion object {
        private val first = hashSetOf(
            'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p',
        )
        private val second = hashSetOf(
            'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l',
        )
        private val third = hashSetOf(
            'z', 'x', 'c', 'v', 'b', 'n', 'm',
        )
    }

    fun findWords(words: Array<String>): Array<String> {
        val result = mutableListOf<String>()

        words.forEach { word ->
            val row = when {
                first.contains(word.first().toLowerCase()) -> first
                second.contains(word.first().toLowerCase()) -> second
                else -> third
            }
            for (i in word.indices) {
                if (!row.contains(word[i].toLowerCase())) {
                    break
                }
                if (i == word.lastIndex) {
                    result.add(word)
                }
            }
        }

        return result.toTypedArray()
    }
}
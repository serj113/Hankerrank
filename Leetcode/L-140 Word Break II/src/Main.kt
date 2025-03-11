fun main() {
//    val sb = StringBuilder("abc")
//    sb.insert(2, ' ')
//    println(sb.toString())
    Solution()
        .wordBreak(
            s = "catsanddog",
            wordDict = listOf(
                "cat", "cats", "and", "sand", "dog",
            ),
        )
        .forEach {
            println(it)
        }
}

class Solution {
    private var dictionary = hashSetOf<String>()
    private var result = mutableListOf<String>()

    fun wordBreak(s: String, wordDict: List<String>): List<String> {
        dictionary = wordDict.toHashSet()
        addSplitWord(
            start = 0,
            end = 1,
            s = s,
        )

        return result
    }

    private fun addSplitWord(start: Int, end: Int, s: String) {
        if (end == s.length) {
            if (dictionary.contains(s.substring(start, end))) {
                result.add(s)
            }
            return
        }
        addSplitWord(start, end + 1, s)
        if (dictionary.contains(s.substring(start, end))) {
            addSplitWord(end + 1, end + 2, s.replaceRange(startIndex = end, endIndex = end, " "))
        }
    }
}
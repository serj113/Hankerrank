fun main() {
    Solution()
        .letterCasePermutation(
            s = "a1b2",
        )
        .forEach {
            print("$it ")
        }
}

class Solution {
    val result = mutableListOf<String>()

    fun letterCasePermutation(s: String): List<String> {
        getPermutation(s, 0)
        return result
    }

    private fun getPermutation(s: String, i: Int) {
        if (i == s.length) {
            result.add(s)
            return
        }

        if (s[i] in '0'..'9') {
            getPermutation(s, i + 1)
        } else {
            getPermutation(
                s = s.replaceRange(startIndex = i, endIndex = i + 1, replacement = "${s[i].lowercaseChar()}"),
                i = i + 1,
            )
            getPermutation(
                s = s.replaceRange(startIndex = i, endIndex = i + 1, replacement = "${s[i].uppercaseChar()}"),
                i = i + 1,
            )
        }
    }
}
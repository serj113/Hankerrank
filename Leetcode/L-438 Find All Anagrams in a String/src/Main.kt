fun main() {
    Solution()
        .findAnagrams("abab", "ab")
        .forEach {
            println(it)
        }
}

// c b a e b a b a c d
// 0 1 2 3 4 5 6 7 8 9

class Solution {
    private val answer = MutableList(26) { 0 }
    private val target = MutableList(26) { 0 }

    fun findAnagrams(s: String, p: String): List<Int> {
        val result = mutableListOf<Int>()
        val size = p.length - 1
        p.forEach { c ->
            target[c - 'a'] += 1
        }

        s.forEachIndexed { index, c ->
            answer[c - 'a'] += 1
            if (index > size) {
                answer[s[index - (size + 1)] - 'a'] -= 1
            }

            if (answer == target) {
                result.add(index - size)
            }
        }

        return result
    }
}
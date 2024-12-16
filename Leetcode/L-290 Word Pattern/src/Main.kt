fun main() {
    println("Hello World!")
}

class Solution {
    fun wordPattern(pattern: String, s: String): Boolean {
        val words = s.split(" ")
        if (pattern.length != words.size) return false
        val maps = hashMapOf<Char, String>()

        pattern.forEachIndexed { index, c ->
            if ((maps.containsKey(c) || maps.containsValue(words[index])) && maps[c] != words[index]) {
                return false
            } else {
                maps[c] = words[index]
            }
        }

        return true
    }
}
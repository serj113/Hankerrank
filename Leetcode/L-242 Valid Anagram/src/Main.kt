fun main() {
    println("Hello World!")
}

class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        val sSorted = s.map { it }.sorted()
        val tSorted = t.map { it }.sorted()
        return sSorted == tSorted
    }
}
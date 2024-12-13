fun main() {
    println(
        Solution().canConstruct(
            ransomNote = "aa",
            magazine = "aab",
        )
    )
}

class Solution {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val ransomHash = hashMapOf<Char, Int>()
        ransomNote.forEach {
            ransomHash[it] = (ransomHash[it] ?: 0) + 1
        }
        val magazineHash = hashMapOf<Char, Int>()
        magazine.forEach {
            magazineHash[it] = (magazineHash[it] ?: 0) + 1
        }
        ransomHash.forEach {
            if ((magazineHash[it.key] ?: 0) < it.value) return false
        }
        return true
    }
}
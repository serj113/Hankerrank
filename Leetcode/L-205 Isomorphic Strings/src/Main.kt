fun main() {
    println(
        Solution().isIsomorphic(
            s = "egg",
            t = "add",
        )
    )
}

class Solution {
    fun isIsomorphic(s: String, t: String): Boolean {
        val map = hashMapOf<Char, Char>()
        for (i in 0..s.lastIndex) {
            if (map.containsKey(s[i]) || map.containsValue(t[i])) {
                if (map[s[i]] != t[i]) return false
            } else {
                map[s[i]] = t[i]
            }
        }

        return true
    }
}
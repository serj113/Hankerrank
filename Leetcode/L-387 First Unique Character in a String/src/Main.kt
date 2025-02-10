fun main() {
    println(
        Solution()
            .firstUniqChar("aabb")
    )
}

class Solution {
    fun firstUniqChar(s: String): Int {
        val list = mutableListOf<Char>()
        val map = hashMapOf<Char, Int>()
        s.forEachIndexed { index, c ->
            if (map.containsKey(c)) {
                if (list.contains(c)) {
                    list.remove(c)
                }
            } else {
                list.add(c)
                map[c] = index
            }
        }

        return map.getOrElse(list.firstOrNull() ?: '-') { -1 }
    }
}
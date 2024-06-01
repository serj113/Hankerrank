import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

fun main() {
    val result = Solution().minDeletions("bbcebab")
    println("result $result")
}

class Solution {
    fun minDeletions(s: String): Int {
        val charSet = mutableMapOf<Char, Int>()
        val set = hashSetOf<Int>()
        var count = 0
        s.forEach { char ->
            if (charSet.contains(char)) {
                charSet[char] = (charSet[char] ?: 0).plus(1)
            } else {
                charSet[char] = 1
            }
        }
        charSet.values.forEach { value ->
            var temp = value
            while (set.contains(temp) && temp != 0) {
                temp -= 1
                count++
            }
            set.add(temp)
        }
        return count
    }
}
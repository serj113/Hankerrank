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

/*
 * Complete the 'anagram' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts STRING s as parameter.
 */

fun anagram(s: String): Int {
    if (s.length % 2 == 1) return -1
    val mid = s.length / 2
    var count = mid
    val map = hashMapOf<Char, Int>()
    for (i in s.indices) {
        if (i >= mid) {
            if (map.containsKey(s[i]) && (map[s[i]] ?: 0) > 0) {
                map[s[i]] = (map[s[i]] ?: 0) - 1
                count--
            }
        } else {
            map[s[i]] = (map[s[i]] ?: 0) + 1
        }
    }
    return count
}

fun main(args: Array<String>) {
    val q = readLine()!!.trim().toInt()

    for (qItr in 1..q) {
        val s = readLine()!!

        val result = anagram(s)

        println(result)
    }
}

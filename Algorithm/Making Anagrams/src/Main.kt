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
 * Complete the 'makingAnagrams' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. STRING s1
 *  2. STRING s2
 */

fun makingAnagrams(s1: String, s2: String): Int {
    val map = hashMapOf<Char, Int>()
    var count = 0
    s1.forEach { value ->
        map[value] = (map[value] ?: 0) + 1
    }
    s2.forEach { value ->
        if (map.containsKey(value)) {
            if (map[value] == 1) {
                map.remove(value)
            } else {
                map[value] = (map[value] ?: 0) - 1
            }
        } else count++
    }

    map.forEach { (_, value) ->
        count += value
    }

    return count
}

fun main(args: Array<String>) {
    val s1 = readLine()!!

    val s2 = readLine()!!

    val result = makingAnagrams(s1, s2)

    println(result)
}

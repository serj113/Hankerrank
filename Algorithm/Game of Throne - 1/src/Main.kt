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
 * Complete the 'gameOfThrones' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts STRING s as parameter.
 */

fun gameOfThrones(s: String): String {
    val map = hashMapOf<Char, Int>()
    s.forEach { c ->
        map[c] = (map[c] ?: 0) + 1
    }
    val odd = map.count {
        it.value % 2 == 1
    }
    return if ((s.length % 2 == 1 && odd == 1) || (s.length % 2 == 0 && odd == 0)) {
        "YES"
    } else "NO"
}

fun main(args: Array<String>) {
    val s = readLine()!!

    val result = gameOfThrones(s)

    println(result)
}
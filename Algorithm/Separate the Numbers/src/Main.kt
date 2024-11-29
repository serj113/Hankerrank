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
 * Complete the 'separateNumbers' function below.
 *
 * The function accepts STRING s as parameter.
 */

fun separateNumbers(s: String): Unit {
    if (s.length == 1 || s.first() == '0') {
        println("NO")
        return
    }

    for (i in 1..s.length/2) {
        val next = (s.substring(0..<i).toLong() + 1).toString()
        if (sequence(next, s.substring(i..s.lastIndex))) {
            println("YES ${s.substring(0..<i)}")
            return
        }
    }
    println("NO")
}

fun sequence(next: String, s: String): Boolean {
    if (next.length > s.length) return false
    if (next.length == s.length && next.toLong() == s.toLong()) return true
    return if (s.substring(0..next.lastIndex) == next) {
        sequence((next.toLong() + 1).toString(), s.substring(next.length..s.lastIndex))
    } else {
        false
    }
}

fun main(args: Array<String>) {
    val q = readLine()!!.trim().toInt()

    for (qItr in 1..q) {
        val s = readLine()!!

        separateNumbers(s)
    }
}

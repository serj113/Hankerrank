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
 * Complete the 'theLoveLetterMystery' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts STRING s as parameter.
 */

fun theLoveLetterMystery(s: String): Int {
    var i = 0
    var j = s.lastIndex
    var count = 0
    while (i < j) {
        count += s[i].code.coerceAtLeast(s[j].code) - s[i].code.coerceAtMost(s[j].code)
        i++
        j--
    }

    return count
}

fun main(args: Array<String>) {
    val q = readLine()!!.trim().toInt()

    for (qItr in 1..q) {
        val s = readLine()!!

        val result = theLoveLetterMystery(s)

        println(result)
    }
}

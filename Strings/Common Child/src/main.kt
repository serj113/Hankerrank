import java.io.*
import java.lang.Math.max
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
 * Complete the 'commonChild' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. STRING s1
 *  2. STRING s2
 */

lateinit var table: Array<Array<Int>>

fun commonChild(s1: String, s2: String, p1: Int, p2: Int): Int {
    return if (p1 >= s1.length || p2 >= s2.length) {
        0
    } else {
        if (table[p1][p2] < 0) {
            table[p1][p2] = if (s1[p1] == s2[p2]) {
                1 + commonChild(s1, s2, p1 + 1, p2 + 1)
            } else {
                kotlin.math.max(commonChild(s1, s2, p1 + 1, p2), commonChild(s1, s2, p1, p2 + 1))
            }
        }
        table[p1][p2]
    }
}

fun main(args: Array<String>) {
    val s1 = readLine()!!

    val s2 = readLine()!!

    table = Array(s1.length) { Array(s2.length) { -1 } }
    val result = commonChild(s1, s2, 0, 0)

    println(result)
}
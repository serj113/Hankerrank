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
 * Complete the 'fairRations' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts INTEGER_ARRAY B as parameter.
 */

fun fairRations(B: Array<Int>): String {
    var count = 0
    for (i in B.indices) {
        if (i != B.size - 1 && B[i] % 2 == 1) {
            B[i + 1]++
            count++
        }
    }
    return if (B.last() % 2 == 1) {
        "NO"
    } else (count * 2).toString()
}

fun main(args: Array<String>) {
    val N = readLine()!!.trim().toInt()

    val B = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = fairRations(B)

    println(result)
}
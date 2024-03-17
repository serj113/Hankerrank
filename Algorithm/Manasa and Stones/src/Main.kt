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
import kotlin.math.abs
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

/*
 * Complete the 'stones' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts following parameters:
 *  1. INTEGER n
 *  2. INTEGER a
 *  3. INTEGER b
 */


//fun stones(n: Int, a: Int, b: Int): Array<Int> {
//    var result = hashSetOf<Int>()
//    for (i in 0..<n) {
//        val value = ((n-1-i) * a) + ((i) * b)
//        if (!result.contains(value)) {
//            result.add(value)
//        }
//    }
//    return result.toTypedArray().sortedArray()
//}

fun stones(n: Int, a: Int, b: Int): Array<Int> {
    var result = arrayOf<Int>()
    var c = a
    var d = b
    if (b < a) {
        c = b
        d = a
    }
    val diff = abs(d - c)
    val start = (n - 1) * c
    result += start
    for (i in 1..<n) {
        val value = start + (i * diff)
        if (!result.contains(value)) {
            result += value
        }
    }
    return result
}

fun main(args: Array<String>) {
    val T = readLine()!!.trim().toInt()

    for (TItr in 1..T) {
        val n = readLine()!!.trim().toInt()

        val a = readLine()!!.trim().toInt()

        val b = readLine()!!.trim().toInt()

        val result = stones(n, a, b)

        println(result.joinToString(" "))
    }
}

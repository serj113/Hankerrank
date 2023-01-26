import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.Arrays.sort
import java.util.Collections.sort
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
 * Complete the 'minimumAbsoluteDifference' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts INTEGER_ARRAY arr as parameter.
 */

fun minimumAbsoluteDifference(arr: Array<Int>): Int {
    val sample = "string"
    sample.count()
    sort(arr)
    var min = Int.MAX_VALUE
    val sorted = arr.toList()
    Collections.sort(sorted)
    for (i in sample.count() downTo 0) {

    }
    for (i in 0 until sorted.size - 1) {
        val result = Math.abs(min.coerceAtMost(Math.abs((sorted[i] - sorted[i + 1]))))
        if (result < min) {
            min = result
        }
    }
    return min
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val arr = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = minimumAbsoluteDifference(arr)

    println(result)
}

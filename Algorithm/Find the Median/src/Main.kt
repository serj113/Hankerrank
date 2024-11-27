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
 * Complete the 'findMedian' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts INTEGER_ARRAY arr as parameter.
 */

val sorted: MutableList<Int> = mutableListOf()

fun findMedian(arr: Array<Int>): Int {
    sorted.add(arr.first())
    for (i in 1..arr.lastIndex) {
        add(arr[i], 0, sorted.lastIndex)
    }

    return sorted[sorted.lastIndex/2]
}

fun add(value: Int, start: Int, end: Int) {
    if (start == end) {
        val i = if (value < sorted[start]) {
            start
        } else start + 1
        sorted.add(i, value)
    } else {
        val mid = (start + end) / 2
        if (value < sorted[mid]) {
            add(value, start, mid)
        } else {
            add(value, mid + 1, end)
        }
    }
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val arr = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = findMedian(arr)

    println(result)
}

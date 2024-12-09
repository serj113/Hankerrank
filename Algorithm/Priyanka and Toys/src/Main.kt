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
 * Complete the 'toys' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts INTEGER_ARRAY w as parameter.
 */

val sorted: MutableList<Int> = mutableListOf()

fun toys(w: Array<Int>): Int {
    sorted.add(w.first())
    for (i in 1..w.lastIndex) {
        add(w[i], 0, sorted.lastIndex)
    }

    var count = 1
    var current = sorted.first() + 4
    for (i in 1..sorted.lastIndex) {
        if (sorted[i] > current) {
            current = sorted[i] + 4
            count++
        }
    }

    return count
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

    val w = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = toys(w)

    println(result)
}
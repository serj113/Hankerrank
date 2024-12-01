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
import kotlin.math.pow
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

/*
 * Complete the 'marcsCakewalk' function below.
 *
 * The function is expected to return a LONG_INTEGER.
 * The function accepts INTEGER_ARRAY calorie as parameter.
 */

val sorted: MutableList<Int> = mutableListOf()

fun marcsCakewalk(calorie: Array<Int>): Long {
    sorted.add(calorie.first())
    for (i in 1..calorie.lastIndex) {
        add(calorie[i], 0, sorted.lastIndex)
    }
    var result = 0L
    sorted.forEachIndexed { index, item ->
        result += 2.0.pow(index.toDouble()).toLong() * item
    }

    return result
}

fun add(value: Int, start: Int, end: Int) {
    if (start == end) {
        val i = if (value > sorted[start]) {
            start
        } else start + 1
        sorted.add(i, value)
    } else {
        val mid = (start + end) / 2
        if (value > sorted[mid]) {
            add(value, start, mid)
        } else {
            add(value, mid + 1, end)
        }
    }
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val calorie = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = marcsCakewalk(calorie)

    println(result)
}

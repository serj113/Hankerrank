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
 * Complete the 'closestNumbers' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts INTEGER_ARRAY arr as parameter.
 */

val sorted: MutableList<Int> = mutableListOf()

fun closestNumbers(arr: Array<Int>): Array<Int> {
    sorted.add(arr.first())
    for (i in 1..arr.lastIndex) {
        add(arr[i], 0, sorted.lastIndex)
    }

    var min = Int.MAX_VALUE
    var result = arrayListOf<Int>()

    for (i in 0..< sorted.lastIndex) {
        if ((sorted[i+1] - sorted[i]) < min) {
            min = (sorted[i+1] - sorted[i])
            result = arrayListOf(
                sorted[i],
                sorted[i+1],
            )
        } else if ((sorted[i+1] - sorted[i]) == min) {
            result.add(sorted[i])
            result.add(sorted[i+1])
        }
    }

    return result.toTypedArray()
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

    val result = closestNumbers(arr)

    println(result.joinToString(" "))
}

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

fun findMedian(arr: Array<Int>): Int {
    val sorted: MutableList<Int> = arr.toMutableList()
    for (i in 0..<arr.lastIndex) {
        for (j in 1..arr.lastIndex) {
            if (arr[i] > arr[j]) {
                arr[i] = arr[j]
                arr[j] = temp
            } else {
                break
            }
        }
    }

    return sorted[arr.lastIndex/2]
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val arr = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = findMedian(arr)

    println(result)
}

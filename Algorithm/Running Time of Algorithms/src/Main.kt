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
 * Complete the 'runningTime' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts INTEGER_ARRAY arr as parameter.
 */

fun runningTime(arr: Array<Int>): Int {
    var count = 0
    for (i in arr.indices) {
        if (i > 0) {
            var j = i - 1
            while (j >= 0 && arr[j] > arr[j+1]) {
                val temp = arr[j]
                arr[j] = arr[j+1]
                arr[j+1] = temp
                arr[j]
                j--
                count++
            }
        }
    }
    return count
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val arr = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = runningTime(arr)

    println(result)
}

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
 * Complete the 'cutTheSticks' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts INTEGER_ARRAY arr as parameter.
 */

fun cutTheSticks(arr: Array<Int>): Array<Int> {
    arr.sort()
    var counts = intArrayOf()
    var isCutting = true
    while (isCutting) {
        var min = Int.MAX_VALUE
        var count = 0
        for (index in arr.indices) {
            if (arr[index] == 0) continue
            if (arr[index] < min) {
                min = arr[index]
            }
            arr[index] -= min
            count++
        }
        if (count == 0) {
            isCutting = false
        } else {
            counts += count
        }
    }
    return counts.toTypedArray()
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val arr = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = cutTheSticks(arr)

    println(result.joinToString("\n"))
}

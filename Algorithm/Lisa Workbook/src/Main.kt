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
 * Complete the 'workbook' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER n
 *  2. INTEGER k
 *  3. INTEGER_ARRAY arr
 */

fun workbook(n: Int, k: Int, arr: Array<Int>): Int {
    var count = 0
    var curPage = 1
    for (i in arr) {
        var remain = i
        var start = 1
        var end = if (k > i) i else k
        while (remain > 0) {
            if (curPage >= start && curPage <= end) {
                count++
            }
            start += k
            end = if ((end + k) > i) i else end + k
            remain -= k
            curPage++
        }
    }
    return count
}

fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val n = first_multiple_input[0].toInt()

    val k = first_multiple_input[1].toInt()

    val arr = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = workbook(n, k, arr)

    println(result)
}
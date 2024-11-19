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
 * Complete the 'icecreamParlor' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts following parameters:
 *  1. INTEGER m
 *  2. INTEGER_ARRAY arr
 */

fun icecreamParlor(m: Int, arr: Array<Int>): Array<Int> {
    val map = hashMapOf<Int, Int>()
    val result = IntArray(2)
    for (i in arr.indices) {
        if (map.containsKey(arr[i])) {
            result[0] = (map[arr[i]] ?: 0) + 1
            result[1] = i + 1
            break
        } else {
            map[m - arr[i]] = i
        }
    }
    return result.toTypedArray()
}

fun main(args: Array<String>) {
    val t = readLine()!!.trim().toInt()

    for (tItr in 1..t) {
        val m = readLine()!!.trim().toInt()

        val n = readLine()!!.trim().toInt()

        val arr = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

        val result = icecreamParlor(m, arr)

        println(result.joinToString(" "))
    }
}

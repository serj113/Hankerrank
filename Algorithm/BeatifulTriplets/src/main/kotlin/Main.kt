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
 * Complete the 'beautifulTriplets' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER d
 *  2. INTEGER_ARRAY arr
 */

fun beautifulTriplets(d: Int, arr: Array<Int>): Int {
    var count = 0
    val cache = hashMapOf<Int, Int>()
    val second = hashSetOf<Int>()
    for (i in arr) {
        cache[i] = if (cache.containsKey(i)) {
            (cache[i] ?: 0) + 1
        } else 1

        if (cache.containsKey(i - d) && (cache[i] ?: 0) > 0) {
            second.add(i)
        }
        if (second.contains(i - d)) {
            val firstCount = cache[i - (2 * d)] ?: 0
            val secondCount =  cache[i - d] ?: 0
            count += (firstCount * secondCount)
        }
    }
    return count
}

fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val n = first_multiple_input[0].toInt()

    val d = first_multiple_input[1].toInt()

    val arr = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = beautifulTriplets(d, arr)

    println(result)
}

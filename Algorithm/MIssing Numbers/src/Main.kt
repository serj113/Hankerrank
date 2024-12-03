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
 * Complete the 'missingNumbers' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts following parameters:
 *  1. INTEGER_ARRAY arr
 *  2. INTEGER_ARRAY brr
 */

fun missingNumbers(arr: Array<Int>, brr: Array<Int>): Array<Int> {
    val aMap = hashMapOf<Int, Int>()
    val result = mutableListOf<Int>()
    arr.forEach { value ->
        aMap[value] = (aMap[value] ?: 0) + 1
    }
    brr.forEach { value ->
        if (aMap.containsKey(value)) {
            if (aMap[value] == 1) {
                aMap.remove(value)
            } else {
                aMap[value] = (aMap[value] ?: 0) - 1
            }
        } else {
            result.add(value)
        }
    }
    return result.toTypedArray().sortedArray()
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val arr = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val m = readLine()!!.trim().toInt()

    val brr = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = missingNumbers(arr, brr)

    println(result.joinToString(" "))
}
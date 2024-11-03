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
 * Complete the 'serviceLane' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts following parameters:
 *  1. INTEGER n
 *  2. 2D_INTEGER_ARRAY cases
 */

fun serviceLane(width: Array<Int>, cases: Array<Array<Int>>): Array<Int> {
    val result = IntArray(cases.size)
    cases.forEachIndexed { index, case ->
        var min = Int.MAX_VALUE
        for (i in case.first()..case.last()) {
            if (width[i] < min) {
                min = width[i]
            }
        }
        result[index] = min
    }
    return result.toTypedArray()
}

fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val n = first_multiple_input[0].toInt()

    val t = first_multiple_input[1].toInt()

    val width = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val cases = Array<Array<Int>>(t, { Array<Int>(2, { 0 }) })

    for (i in 0 until t) {
        cases[i] = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
    }

    val result = serviceLane(width, cases)

    println(result.joinToString("\n"))
}

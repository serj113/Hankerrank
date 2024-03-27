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
 * Complete the 'taumBday' function below.
 *
 * The function is expected to return a LONG_INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER b
 *  2. INTEGER w
 *  3. INTEGER bc
 *  4. INTEGER wc
 *  5. INTEGER z
 */

fun taumBday(b: Int, w: Int, bc: Int, wc: Int, z: Int): Long {
    var x = if (bc < wc + z) bc else wc + z
    var y = if (wc < bc + z) wc else bc + z
    return (b.toLong() * x) + (w.toLong() * y)
}

fun main(args: Array<String>) {
    val t = readLine()!!.trim().toInt()

    for (tItr in 1..t) {
        val first_multiple_input = readLine()!!.trimEnd().split(" ")

        val b = first_multiple_input[0].toInt()

        val w = first_multiple_input[1].toInt()

        val second_multiple_input = readLine()!!.trimEnd().split(" ")

        val bc = second_multiple_input[0].toInt()

        val wc = second_multiple_input[1].toInt()

        val z = second_multiple_input[2].toInt()

        val result = taumBday(b, w, bc, wc, z)

        println(result)
    }
}
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
import kotlin.math.pow
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

/*
 * Complete the 'extraLongFactorials' function below.
 *
 * The function accepts INTEGER n as parameter.
 */

fun extraLongFactorials(n: Int): Unit {
    val arr = mutableListOf(1)
    for (i in 1..n) {
        var j = 0
        val maxJ = arr.lastIndex
        var carry = 0
        while (j <= maxJ) {
            val result = (arr[j] * i) + carry
            carry = result / 10
            arr[j] = result % 10
            if (j >= maxJ) {
                while (carry > 0) {
                    arr.add(j + 1, carry % 10)
                    carry /= 10
                    j++
                }
            }
            j++
        }
    }

    var result = ""
    for (i in arr.lastIndex downTo 0) {
        result += arr[i].toString()
    }
    println(result)
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    extraLongFactorials(n)
}

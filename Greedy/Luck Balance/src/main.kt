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
 * Complete the 'luckBalance' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER k
 *  2. 2D_INTEGER_ARRAY contests
 */

fun luckBalance(k: Int, contests: Array<Array<Int>>): Int {
    var balance = 0
    var tempK = k
    val comparator = kotlin.Comparator { o1: Array<Int>, o2: Array<Int> ->
        if (o1[1] == o2[1]) {
            compareValues(o2[0], o1[0])
        } else compareValues(o2[1], o1[1])
    }
    contests.sortWith(comparator)
    for (num in contests) {
        if (num[1] == 0) {
            balance += num[0]
        } else {
            if (tempK > 0) {
                balance += num[0]
                tempK--
            } else balance -= num[0]
        }
    }
    return balance
}

fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val n = first_multiple_input[0].toInt()

    val k = first_multiple_input[1].toInt()

    val contests = Array<Array<Int>>(n, { Array<Int>(2, { 0 }) })

    for (i in 0 until n) {
        contests[i] = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
    }

    val result = luckBalance(k, contests)

    println(result)
}
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
 * Complete the 'acmTeam' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts STRING_ARRAY topic as parameter.
 */

fun acmTeam(topics: Array<String>): Array<Int> {
    val result = hashMapOf<Int, Int>()
    var max = Int.MIN_VALUE
    for (i in 0..topics.size - 2) {
        for (j in (i+1)..<topics.size) {
            var tempMax = 0
            for (k in 0..<topics[i].length) {
                if (topics[i][k] == '1' || topics[j][k] == '1') {
                    tempMax++
                }
            }
            result[tempMax] = (result[tempMax] ?: 0) + 1
            if (tempMax > max) {
                max = tempMax
            }
        }
    }
    return intArrayOf(
        max,
        result[max] ?: 0
    ).toTypedArray()
}

fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val n = first_multiple_input[0].toInt()

    val m = first_multiple_input[1].toInt()

    val topic = Array<String>(n, { "" })
    for (i in 0 until n) {
        val topicItem = readLine()!!
        topic[i] = topicItem
    }

    val result = acmTeam(topic)

    println(result.joinToString("\n"))
}

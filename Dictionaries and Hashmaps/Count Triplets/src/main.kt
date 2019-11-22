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

// Complete the countTriplets function below.
fun countTriplets(arr: Array<Long>, r: Long): Long {
    val map1 = hashMapOf<Long, Long>()
    val map2 = hashMapOf<Long, Long>()
    var counter = 0L
    for (value in arr) {
        counter += map2[value] ?: 0L
        if (value % r == 0L) {
            map2[value*r] = (map1[value/r] ?: 0L) + (map2[value*r] ?: 0L)
        }
        map1[value] = 1 + (map1[value] ?: 0L)
    }
    return counter
}

fun main(args: Array<String>) {
    val nr = readLine()!!.trimEnd().split(" ")

    val n = nr[0].toInt()

    val r = nr[1].toLong()

    val arr = readLine()!!.trimEnd().split(" ").map{ it.toLong() }.toTypedArray()

    val ans = countTriplets(arr, r)

    println(ans)
}

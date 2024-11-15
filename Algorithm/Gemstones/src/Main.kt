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
 * Complete the 'gemstones' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts STRING_ARRAY arr as parameter.
 */

fun gemstones(arr: Array<String>): Int {
    val map = hashMapOf<Char, Int>()
    var count = 0
    arr.forEach { word ->
        val set = hashSetOf<Char>()
        word.forEach { c ->
            if (!set.contains(c)) {
                set.add(c)
                val value = (map[c] ?: 0) + 1
                map[c] = value
                if (value == arr.size) count++
            }
        }
    }
    return count
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val arr = Array<String>(n, { "" })
    for (i in 0 until n) {
        val arrItem = readLine()!!
        arr[i] = arrItem
    }

    val result = gemstones(arr)

    println(result)
}

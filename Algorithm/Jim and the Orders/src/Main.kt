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
 * Complete the 'jimOrders' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts 2D_INTEGER_ARRAY orders as parameter.
 */

val sorted: MutableList<Pair<Int, Int>> = mutableListOf()

fun jimOrders(orders: Array<Array<Int>>): Array<Int> {
    sorted.add(Pair(orders.first().first() + orders.first().last(), 1))
    for (i in 1..orders.lastIndex) {
        add(
            value = Pair(orders[i].first() + orders[i].last(), i + 1),
            start = 0,
            end = sorted.lastIndex
        )
    }

    return sorted.map {
        it.second
    }.toTypedArray()
}

fun add(value: Pair<Int, Int>, start: Int, end: Int) {
    if (start == end) {
        val i = if (value.first < sorted[start].first) {
            start
        } else start + 1
        sorted.add(i, value)
    } else {
        val mid = (start + end) / 2
        if (value.first < sorted[mid].first) {
            add(value, start, mid)
        } else {
            add(value, mid + 1, end)
        }
    }
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val orders = Array<Array<Int>>(n, { Array<Int>(2, { 0 }) })

    for (i in 0 until n) {
        orders[i] = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
    }

    val result = jimOrders(orders)

    println(result.joinToString(" "))
}

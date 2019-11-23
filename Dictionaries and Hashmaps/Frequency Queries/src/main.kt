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

// Complete the freqQuery function below.
fun freqQuery(queries: Array<Array<Int>>): Array<Int> {
    val tables = hashMapOf<Int, Int>()
    val truth = hashMapOf<Int, Int>()
    val result = arrayListOf<Int>()
    for (query in queries) {
        when (query[0]) {
            1 -> {
                val value = 1 + (tables[query[1]] ?: 0)
                tables[query[1]] = value
                if (truth.containsKey(value - 1) &&
                    truth[value - 1] ?: 0 > 0) {
                    truth[value - 1] = (truth[value - 1] ?: 0) - 1
                }
                truth[value] = 1 + (truth[value] ?: 0)
            }
            2 -> {
                if (tables.containsKey(query[1]) && tables[query[1]] ?: 0 > 0) {
                    val value = (tables[query[1]] ?: 0) - 1
                    truth[value] = (truth[value] ?: 0) + 1
                    if (truth.containsKey(value + 1) &&
                        truth[value + 1] ?: 0 > 0) {
                        truth[value + 1] = (truth[value + 1] ?: 0) - 1
                    }
                    tables[query[1]] = value
                }
            }
            3 -> {
                result.add(if (truth.containsKey(query[1]) && truth[query[1]] ?: 0 > 0) 1 else 0)
            }
        }
    }
    return result.toTypedArray()
}

fun main(args: Array<String>) {
    val q = readLine()!!.trim().toInt()

    val queries = Array<Array<Int>>(q, { Array<Int>(2, { 0 }) })

    for (i in 0 until q) {
        queries[i] = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
    }

    val ans = freqQuery(queries)

    println(ans.joinToString("\n"))
}

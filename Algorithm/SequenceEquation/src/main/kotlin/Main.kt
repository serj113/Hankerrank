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
 * Complete the 'permutationEquation' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts INTEGER_ARRAY p as parameter.
 */

fun permutationEquation(p: Array<Int>): Array<Int> {
    val cache = hashMapOf<Int, Int>()
    val result = Array(p.size) { 0 }
    for (i in p.indices) {
        cache[p[i]] = i + 1
    }
    for (i in p.indices) {
        result[i] = cache[cache[i+1] ?: 0] ?: 0
    }
    return result
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val p = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = permutationEquation(p)

    println(result.joinToString("\n"))
}
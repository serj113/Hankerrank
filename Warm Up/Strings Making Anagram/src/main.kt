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

// Complete the makeAnagram function below.
fun makeAnagram(a: String, b: String): Int {
    val tables = hashMapOf<Char, Int>()
    for (char in a) {
        if (tables.containsKey(char)) {
            tables[char] = tables[char]!!.plus(1)
        } else {
            tables[char] = 1
        }
    }
    for (char in b) {
        if (tables.containsKey(char)) {
            tables[char] = tables[char]!!.minus(1)
        } else {
            tables[char] = -1
        }
    }
    return tables.map { Math.abs(it.value) }.sum()
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val a = scan.nextLine()

    val b = scan.nextLine()

    val res = makeAnagram(a, b)

    println(res)
}

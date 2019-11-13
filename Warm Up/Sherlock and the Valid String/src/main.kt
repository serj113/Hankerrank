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

// Complete the isValid function below.
fun isValid(s: String): String {
    var tables = hashMapOf<Char, Int>()
    var min = Int.MAX_VALUE
    var max = Int.MIN_VALUE
    for (char in s) {
        if (tables.containsKey(char)) {
            tables[char] = tables[char]!!.plus(1)
        } else {
            tables[char] = 1
        }
        if (tables[char]!! > max) {
            max =  tables[char]!!
        }
    }
    var averageMax = 0
    for ((_, int) in tables) {
        if (int == max) {
            averageMax += 1
        }
        if (int < min) {
            min = int
        }
    }
    if (tables.count() == 2 && max - min > 1) {
        return "NO"
    }
    if (averageMax == tables.count() - 1 && min == 1) {
        return "YES"
    }
    return if (max - min > 1 || (averageMax > 1 && max != min)) "NO" else "YES"
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val s = scan.nextLine()

    val result = isValid(s)

    println(result)
}

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
 * Complete the 'happyLadybugs' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts STRING b as parameter.
 */

fun happyLadybugs(b: String): String {
    val maps = hashMapOf<Char, Int>()
    val sets = hashSetOf<Char>()
    var empty = 0
    var diff = 0
    var temp = 'a'
    b.forEachIndexed { index, c ->
        if (c == '_') {
            empty++
        } else {
            val value = (maps[c] ?: 0) + 1
            maps[c] = value
            if (value == 1) {
                sets.add(c)
            } else {
                sets.remove(c)
            }
            if (index > 0) {
                if (c != temp) {
                    diff++
                }
            }
        }
        temp = c
    }
    return if (sets.isEmpty() && (((maps.count() - 1) == diff) || empty > 0)) {
        "YES"
    } else "NO"
}

fun main(args: Array<String>) {
    val g = readLine()!!.trim().toInt()

    for (gItr in 1..g) {
        val n = readLine()!!.trim().toInt()

        val b = readLine()!!

        val result = happyLadybugs(b)

        println(result)
    }
}

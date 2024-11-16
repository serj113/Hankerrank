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
 * Complete the 'beautifulBinaryString' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts STRING b as parameter.
 */

const val word = "010"

fun beautifulBinaryString(b: String): Int {
    var wordIndex = 0
    var count = 0
    b.forEach { c ->
        if (c != word[wordIndex]) {
            wordIndex = 0
        }
        if (c == word[wordIndex]) {
            wordIndex++
            if (wordIndex == 3) {
                wordIndex = 0
                count++
            }
        }
    }
    return count
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val b = readLine()!!

    val result = beautifulBinaryString(b)

    println(result)
}

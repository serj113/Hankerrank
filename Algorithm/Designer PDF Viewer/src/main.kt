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
 * Complete the 'designerPdfViewer' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER_ARRAY h
 *  2. STRING word
 */
const val start = 97
fun designerPdfViewer(h: Array<Int>, word: String): Int {
    var max = 0
    for (c in word) {
        val num = c.toInt() - start
        if (h[num] > max) {
            max = h[num]
        }
    }
    return max * word.length
}

fun main(args: Array<String>) {

    val h = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val word = readLine()!!

    val result = designerPdfViewer(h, word)

    println(result)
}
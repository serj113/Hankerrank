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
 * Complete the 'kaprekarNumbers' function below.
 *
 * The function accepts following parameters:
 *  1. INTEGER p
 *  2. INTEGER q
 */

fun kaprekarNumbers(p: Int, q: Int): Unit {
    var invalidRange = true
    for (i in p..q) {
        val j = i.toLong()
        val s = (j * j).toString()
        var l = s.substring(0, s.length/2)
        if (l == "") {
            l = "0"
        }
        val r = s.substring(s.length/2, s.length)
        if (r.toInt() + l.toInt() == i) {
            invalidRange = false
            print("$i ")
        }
    }
    if (invalidRange) println("INVALID RANGE")
}

fun main(args: Array<String>) {
    val p = readLine()!!.trim().toInt()

    val q = readLine()!!.trim().toInt()

    kaprekarNumbers(p, q)
}
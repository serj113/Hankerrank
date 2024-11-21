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
 * Complete the 'caesarCipher' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts following parameters:
 *  1. STRING s
 *  2. INTEGER k
 */

fun caesarCipher(s: String, k: Int): String {
    val builder = StringBuilder()
    val shifter = k % 26
    s.forEach { c ->
        if (c in 'a'..'z' || c in 'A'..'Z') {
            var temp = c + shifter
            if (temp > 'z' || (temp > 'Z' && c <= 'Z')) {
                temp -= 26
            }
            builder.append(temp)
        } else {
            builder.append(c)
        }
    }
    return builder.toString()
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val s = readLine()!!

    val k = readLine()!!.trim().toInt()

    val result = caesarCipher(s, k)

    println(result)
}

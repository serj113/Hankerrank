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
import kotlin.math.max
import kotlin.math.min
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

/*
 * Complete the 'appendAndDelete' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts following parameters:
 *  1. STRING s
 *  2. STRING t
 *  3. INTEGER k
 */

fun appendAndDelete(s: String, t: String, k: Int): String {
    if (k > s.length + t.length) return "Yes"
    var count = k
    var min = min(s.length, t.length)
    for (i in 0..<min) {
        if (s[i] != t[i]) {
            min = i
            break
        }
    }
    count -= (s.length - min) + (t.length - min)
    return if (count >= 0 && count % 2 == 0) "Yes" else "No"
}

fun main(args: Array<String>) {
    val s = readLine()!!

    val t = readLine()!!

    val k = readLine()!!.trim().toInt()

    val result = appendAndDelete(s, t, k)

    println(result)
}

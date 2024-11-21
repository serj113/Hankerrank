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
 * Complete the 'superReducedString' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts STRING s as parameter.
 */

fun superReducedString(s: String): String {
    val stack = ArrayDeque<Char>(s.length)
    for (i in s.indices) {
        stack.lastOrNull()?.let { c ->
            if (c == s[i]) {
                stack.removeLast()
            } else {
                stack.add(s[i])
            }
        } ?: run {
            stack.add(s[i])
        }
    }
    var result = ""
    do {
        val c = stack.removeLastOrNull()
        c?.let {
            result = it + result
        }
    } while (c != null)

    return if (result.isEmpty()) {
        "Empty String"
    } else result
}

fun main(args: Array<String>) {
    val s = readLine()!!

    val result = superReducedString(s)

    println(result)
}

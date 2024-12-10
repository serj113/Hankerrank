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
 * Complete the 'pangrams' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts STRING s as parameter.
 */

fun pangrams(s: String): String {
    val set = hashSetOf<Char>()
    for (c in 'a'..'z') {
        set.add(c)
    }

    s.forEach {
        var temp = it
        if (it in 'A'..'Z') {
            temp = it.lowercaseChar()
        }
        if (set.contains(temp)) {
            set.remove(temp)
        }
        if (set.isEmpty()) {
            return@forEach
        }
    }
    return if (set.isEmpty()) {
        "pangram"
    } else "not pangram"
}

fun main(args: Array<String>) {
    val s = readLine()!!

    val result = pangrams(s)

    println(result)
}

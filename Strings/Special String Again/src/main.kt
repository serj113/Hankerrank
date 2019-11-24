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

// Complete the substrCount function below.
fun substrCount(n: Int, s: String): Long {
    var count = 0L
    for (i in 0 until s.count()) {
        for (j in (i + 1).rangeTo(s.count())) {
            if (isSpecialString(s.substring(i, j))) count++
        }
    }
    return count
}

fun isSpecialString(s: String): Boolean {
    if (s.count() == 1) return true
    val isOdd = s.count() % 2 == 1
    val char = s[0]
    for (i in s.indices) {
        if (isOdd && i == s.count() / 2) continue
        if (s[i] != char) return false
    }
    return true
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val s = scan.nextLine()

    val result = substrCount(n, s)

    println(result)
}

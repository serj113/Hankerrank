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
    var i = 0
    var charCount = IntArray(n) { 0 }
    while (i < n) {
        var j = i + 1
        var lastSame = 1
        while (j < n && s[i] == s[j]) {
            j++
            lastSame++
        }
        charCount[i] = lastSame
        count += lastSame * (lastSame + 1) / 2
        i = j
    }
    for (i in 1 until n) {
        if (s[i] == s[i-1]) charCount[i] = charCount[i - 1]
        if (i > 0 && i < (n - 1) && s[i - 1] == s[i + 1] && s[i] != s[i - 1]) {
            count += Math.min(charCount[i - 1], charCount[i + 1])
        }
    }
    return count
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val s = scan.nextLine()

    val result = substrCount(n, s)

    println(result)
}

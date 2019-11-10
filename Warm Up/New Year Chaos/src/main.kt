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

// Complete the minimumBribes function below.
fun minimumBribes(q: Array<Int>): Unit {
    var bribes = 0
    if (isChaos(q)) {
        println("Too chaotic")
        return
    }
    for (i in q.size - 1 downTo 1) {
        val bottom = if (i - 2 < 0) 0 else i - 2
        for (j in bottom until i) {
            if (q[j] > q[j + 1]) {
                val temp = q[j]
                q[j] = q[j + 1]
                q[j + 1] = temp
                bribes += 1
            }
        }
    }
    println(bribes)
}

fun isChaos(q: Array<Int>): Boolean {
    for (i in q.indices) {
        if (q[i] > i + 3) {
            return true
        }
    }
    return false
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val t = scan.nextLine().trim().toInt()

    for (tItr in 1..t) {
        val n = scan.nextLine().trim().toInt()

        val q = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

        minimumBribes(q)
    }
}

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

// Complete the countingValleys function below.
fun countingValleys(n: Int, s: String): Int {
    var isValley = false
    var level = 0
    var numValley = 0
    s.forEachIndexed { index, c ->
        if (c == 'U') {
            if (isValley && level == -1) {
                numValley += 1
            }
            if (level == 0) {
                isValley = false
            }
            level += 1
        }
        if (c == 'D') {
            if (level == 0) {
                isValley = true
            }
            level -= 1
        }
    }
    return numValley
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val s = scan.nextLine()

    val result = countingValleys(n, s)

    println(result)
}

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

// Complete the maximumToys function below.
fun maximumToys(prices: Array<Int>, k: Int): Int {
    var max = 0
    var total = 0
    Arrays.sort(prices)
    for (price in prices) {
        total += price
        if (total > k) {
            break
        }
        max += 1
    }
    return max
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val nk = scan.nextLine().split(" ")

    val n = nk[0].trim().toInt()

    val k = nk[1].trim().toInt()

    val prices = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    val result = maximumToys(prices, k)

    println(result)
}

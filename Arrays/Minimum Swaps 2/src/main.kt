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

// Complete the minimumSwaps function below.
fun minimumSwaps(arr: Array<Int>): Int {
    val tempArr = Array<Int>(arr.size) { 0 }
    arr.forEachIndexed { idx, value ->
        tempArr[value - 1] = idx
    }
    var min = 0
    for (i in arr.indices) {
        if (i + 1 != arr[i]) {
            var temp = arr[i]
            arr[i] = arr[tempArr[i]]
            arr[tempArr[i]] = temp
            tempArr[temp - 1] = tempArr[i]
            tempArr[i] = i
            min += 1
        }
    }
    return min
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val arr = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    val res = minimumSwaps(arr)

    println(res)
}

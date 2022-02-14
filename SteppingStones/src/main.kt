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

// steppingStoneCount([1, 0, 1, 1, 1, 0, 1])=> 3
// steppingStoneCount([1, 0, 1, 1, 1, 1, 0, 1])=> 4
// Complete the steppingStones function below.
fun steppingStones(arr: Array<Int>): Int {
    var cur = 0
    var min = 0
    while (cur < arr.size) {
        cur += if (cur + 2 < arr.size && arr[cur + 2] == 1) {
            2
        } else {
            1
        }
        min += 1
    }
    return min - 1
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val arr = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    val res = steppingStones(arr)

    println(res)
}

import kotlin.collections.*
import kotlin.io.*
import kotlin.text.*

// Complete the migratoryBirds function below.
fun migratoryBirds(arr: Array<Int>): Int {
    var types = IntArray(5) { 0 }
    var max = 0
    var chosen = 0
    arr.forEach {
        types[it - 1]++
    }
    types.forEachIndexed { idx, i ->
        if (i > max) {
            max = i
            chosen = idx+1
        }
    }
    return chosen
}

fun main(args: Array<String>) {
    val arrCount = readLine()!!.trim().toInt()

    val arr = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = migratoryBirds(arr)

    println(result)
}

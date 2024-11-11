import kotlin.collections.*
import kotlin.io.*
import kotlin.text.*

/*
 * Complete the 'insertionSort1' function below.
 *
 * The function accepts following parameters:
 *  1. INTEGER n
 *  2. INTEGER_ARRAY arr
 */

fun insertionSort1(n: Int, arr: Array<Int>): Unit {
    var process = true
    var cursor = arr.lastIndex
    val right = arr.last()
    while (process) {
        if (cursor != 0 && right < arr[cursor - 1]) {
            arr[cursor] = arr[cursor - 1]
        } else {
            arr[cursor] = right
            process = false
        }
        cursor--
        arr.forEachIndexed { i, value ->
            print(value)
            if (i == arr.lastIndex) {
                println()
            } else {
                print(" ")
            }
        }
    }
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val arr = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    insertionSort1(n, arr)
}

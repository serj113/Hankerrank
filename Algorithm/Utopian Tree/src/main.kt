import kotlin.collections.*
import kotlin.io.*
import kotlin.text.*

/*
 * Complete the 'utopianTree' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts INTEGER n as parameter.
 */

val cache = hashMapOf<Int, Int>()
fun utopianTree(n: Int): Int {
    return cache[n] ?: run {
        val temp = when {
            n == 0 -> {
                1
            }
            (n - 1) % 2 == 0 -> {
                utopianTree(n - 1) * 2
            }
            else -> {
                utopianTree(n - 1) + 1
            }
        }
        cache[n] = temp
        temp
    }
}

fun main(args: Array<String>) {
    val t = readLine()!!.trim().toInt()

    for (tItr in 1..t) {
        val n = readLine()!!.trim().toInt()

        val result = utopianTree(n)

        println(result)
    }
}

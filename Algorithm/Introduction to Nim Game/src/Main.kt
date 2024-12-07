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

/*
 * Complete the 'nimGame' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts INTEGER_ARRAY pile as parameter.
 */

fun nimGame(pile: Array<Int>): String {
    // Write your code here

}

fun main(args: Array<String>) {
    val g = readLine()!!.trim().toInt()

    for (gItr in 1..g) {
        val n = readLine()!!.trim().toInt()

        val pile = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

        val result = nimGame(pile)

        println(result)
    }
}

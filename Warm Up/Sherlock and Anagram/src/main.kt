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

// Complete the sherlockAndAnagrams function below.
fun sherlockAndAnagrams(s: String): Int {
    val substrings = hashMapOf<String, Int>()
    for (i in 0 until s.count()) {
        for (j in (i + 1).rangeTo(s.count())) {
            val substring = s.substring(i, j).toCharArray()
            Arrays.sort(substring)
            val jointedSubstring = substring.joinToString { "$it" }
            if (substrings.containsKey(jointedSubstring)) {
                substrings[jointedSubstring] = substrings[jointedSubstring]!!.plus(1)
            } else {
                substrings[jointedSubstring] = 1
            }
        }
    }
    return substrings.map { it.value.sumN() }.sum()
}

fun Int.sumN() = (this / 2) * (1 + this)

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val q = scan.nextLine().trim().toInt()

    for (qItr in 1..q) {
        val s = scan.nextLine()

        val result = sherlockAndAnagrams(s)

        println(result)
    }
}

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
fun isAnagram(s1: String, s2: String): Boolean {
    if (s1.count() != s2.count()) {
        return false
    }
    
    return true
}

fun sherlockAndAnagrams(s: String): Int {
    val substrings = mutableListOf<String>()
    var count = 0
    for (i in 1 until s.count()) {
        for (j in 0.rangeTo(s.count() - i)) {
            substrings.add(s.substring(j, j+i))
        }
    }
    for (i in 0 until substrings.size - 1) {
        for (j in i+1 until substrings.size) {
            count += if (isAnagram(substrings[i], substrings[j])) 1 else 0
        }
    }
    return count
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val q = scan.nextLine().trim().toInt()

    for (qItr in 1..q) {
        val s = scan.nextLine()

        val result = sherlockAndAnagrams(s)

        println(result)
    }
}

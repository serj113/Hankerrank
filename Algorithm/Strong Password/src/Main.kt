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
 * Complete the 'minimumNumber' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER n
 *  2. STRING password
 */

const val numbers = "0123456789"
const val lower_case = "abcdefghijklmnopqrstuvwxyz"
const val upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
const val special_characters = "!@#$%^&*()-+"
const val minLenght = 6

fun minimumNumber(n: Int, password: String): Int {
    val nums = hashSetOf<Char>()
    numbers.forEach {
        nums.add(it)
    }
    var hasNum = false
    val lowers = hashSetOf<Char>()
    lower_case.forEach {
        lowers.add(it)
    }
    var hasLower = false
    val uppers = hashSetOf<Char>()
    upper_case.forEach {
        uppers.add(it)
    }
    var hasUpper = false
    val specials = hashSetOf<Char>()
    special_characters.forEach {
        specials.add(it)
    }
    var hasSpecial = false

    var count = 0
    password.forEach { c ->
        if (!hasNum && c in nums) {
            hasNum = true
        }
        if (!hasLower && c in lowers) {
            hasLower = true
        }
        if (!hasUpper && c in uppers) {
            hasUpper = true
        }
        if (!hasSpecial && c in specials) {
            hasSpecial = true
        }
        if (hasNum && hasLower && hasUpper && hasSpecial) {
            return@forEach
        }
    }

    if (!hasNum) count++
    if (!hasLower) count++
    if (!hasUpper) count++
    if (!hasSpecial) count++

    return Math.max(count, minLenght - password.length)
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val password = readLine()!!

    val answer = minimumNumber(n, password)

    println(answer)
}

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

// Complete the dayOfProgrammer function below.
fun dayOfProgrammer(year: Int): String {
    var date = 13
    if ((year < 1918 && year % 4 == 0) ||(year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
        date = 12
    } else if (year == 1918) {
        date = 26
    }
    return ("$date" + ".09." + "$year")
}

fun main(args: Array<String>) {
    val year = readLine()!!.trim().toInt()

    val result = dayOfProgrammer(year)

    println(result)
}

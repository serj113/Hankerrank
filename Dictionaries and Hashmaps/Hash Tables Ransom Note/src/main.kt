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

// Complete the checkMagazine function below.
fun checkMagazine(magazine: Array<String>, note: Array<String>): Unit {
    if (note.size > magazine.size) {
        println("No")
        return
    }
    val table = hashMapOf<String, Int>()
    for (word in magazine) {
        if (!table.containsKey(word)) {
            table[word] = 1
        } else {
            table[word] = table[word]!!.plus(1)
        }
    }
    for (word in note) {
        if (table.containsKey(word)) {
            table[word] = table[word]!!.minus(1)
            if (table[word]!! < 0) {
                println("No")
                return
            }
        } else {
            println("No")
            return
        }
    }
    println("Yes")
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val mn = scan.nextLine().split(" ")

    val m = mn[0].trim().toInt()

    val n = mn[1].trim().toInt()

    val magazine = scan.nextLine().split(" ").toTypedArray()

    val note = scan.nextLine().split(" ").toTypedArray()

    checkMagazine(magazine, note)
}

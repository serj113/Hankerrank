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

// Complete the activityNotifications function below.
fun activityNotifications(expenditure: Array<Int>, d: Int): Int {
    val tempMedian = arrayListOf<Int>()
    var counter = 0
    for (i in expenditure.indices) {
        if (i >= d) {
            if (expenditure[i] >= tempMedian.getMedian() * 2) {
                counter++
            }
            tempMedian.remove(expenditure[i - d])
        }
        tempMedian.insertSorted(expenditure[i])
    }
    return counter
}

fun ArrayList<Int>.insertSorted(value: Int) {
    if (size == 0 || value > get(size - 1)) {
        add(value)
    } else if (value < get(0)) {
        add(0, value)
    } else if (size % 2 == 0) {
        if (value > get(size / 2)) {
            for (i in (size / 2) until size) {
                if (value <= get(i)) {
                    add(i, value)
                }
            }
        } else if (value < get(size / 2)) {
            for (i in (size / 2) downTo 1) {
                if (value >= get(i)) {
                    add(i, value)
                }
            }
        } else {
            add((size / 2), value)
        }
    } else {
        if (value > get(size / 2)) {
            for (i in (size / 2) until size) {
                if (value <= get(i)) {
                    add(i, value)
                }
            }
        } else {
            for (i in (size / 2) downTo 1) {
                if (value >= get(i)) {
                    add(i, value)
                }
            }
        }
    }
}

fun ArrayList<Int>.getMedian(): Int {
    return if (size % 2 == 1) this[size / 2]
    else {
        val tempMed = (get((size / 2) - 1) + get(size / 2))
        tempMed / 2 + if (tempMed % 2 == 1) 1 else 0
    }
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val nd = scan.nextLine().split(" ")

    val n = nd[0].trim().toInt()

    val d = nd[1].trim().toInt()

    val expenditure = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    val result = activityNotifications(expenditure, d)

    println(result)
}

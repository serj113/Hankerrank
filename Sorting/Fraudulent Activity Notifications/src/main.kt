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
import kotlin.math.exp
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

// Complete the activityNotifications function below.
fun activityNotifications(expenditure: Array<Int>, d: Int): Int {
    var count = 0
    val group = mutableListOf<Int>()
    for (i in expenditure.indices) {
        if (i >= d) {
            val tempGroup = mutableListOf<Int>().apply {
                addAll(group)
                sort()
            }
            val median = tempGroup.getMedian()
            if (expenditure[i] >= median * 2) {
                count++
            }
            group.removeAt(0)
        }
        group.add(expenditure[i])
    }
    return count
}

fun MutableList<Int>.getMedian(): Int {
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

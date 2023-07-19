import java.io.*
import java.util.*
import kotlin.Comparator

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)
    val n = scan.nextLine().toInt()
    val humans = mutableListOf<Human>()
    for (i in 1..n) {
        val data = scan.nextLine().split(" ")
        humans.add(
            Human(
                data[0],
                data[1].toInt()
            )
        )
    }
    val comparator = Comparator { o1: Human, o2: Human ->
        if (o1.score == o2.score) {
            compareValues(o1.name, o2.name)
        } else compareValues(o2.score, o1.score)
    }
    humans.sortWith(comparator)
    for (human in humans) {
        println("${human.name} ${human.score}")
    }
}

data class Human(
    val name: String = "",
    val score: Int = 0
)
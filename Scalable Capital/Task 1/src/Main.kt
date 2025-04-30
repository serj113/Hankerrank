import java.util.Queue
import java.util.Stack

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

fun main() {
    println(
        solution("aaAbcCABBc")
    )
    println(
        solution("xyzXYZabcABC")
    )
    println(
        solution("ABCabcAefG")
    )
}

fun solution(letters: String): Int {
    val lower = 'a'..'z'
    val upper = 'A'..'Z'
    val diff = 'a' - 'A'

    val blocked = hashSetOf<Char>()
    val holder = hashSetOf<Char>()
    val counted = hashSetOf<Char>()

    try {

    }catch (e: Exception) {
        println(e.message ?: "")
    }
    letters.forEach { letter ->
        if (letter in lower && counted.contains(letter)) {
            counted.remove(letter)
            blocked.add(letter)
            blocked.add(letter - diff)
        }
        if (!blocked.contains(letter) && letter in lower && !counted.contains(letter)) {
            holder.add(letter)
        }
        if (!blocked.contains(letter) && letter in upper && !holder.contains(letter + diff)) {
            blocked.add(letter)
            blocked.add(letter + diff)
        }
        if (!blocked.contains(letter) && letter in upper && holder.contains(letter + diff)) {
            blocked.add(letter)
            blocked.add(letter + diff)
            holder.remove(letter + diff)
            counted.add(letter + diff)
        }
    }

    return counted.size
}
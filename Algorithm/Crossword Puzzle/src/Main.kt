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
 * Complete the 'crosswordPuzzle' function below.
 *
 * The function is expected to return a STRING_ARRAY.
 * The function accepts following parameters:
 *  1. STRING_ARRAY crossword
 *  2. STRING words
 */
var puzzle: Array<String> = arrayOf()
var listWords = listOf<String>()

fun crosswordPuzzle(crossword: Array<String>, words: String): Array<String> {
    puzzle = crossword
    var x = 0
    var y = 0
    while (crossword[y][x] == '+') {
        if (x == crossword[y].lastIndex) {
            x = 0
            y++
        } else x++
    }

    fillPuzzle(x, y, crossword, words.split(";"))

    return puzzle
}

fun fillPuzzle(x: Int, y: Int, crossword: Array<String>, words: List<String>): Boolean {
    return true
}

fun main(args: Array<String>) {

//    val crossword = Array<String>(10, { "" })
//    for (i in 0 until 10) {
//        val crosswordItem = readLine()!!
//        crossword[i] = crosswordItem
//    }
//
//    val words = readLine()!!
//
//    val result = crosswordPuzzle(crossword, words)
    val result = crosswordPuzzle(
        crossword = arrayOf(
            "+-++++++++",
            "+-++++++++",
            "+-++++++++",
            "+-----++++",
            "+-+++-++++",
            "+-+++-++++",
            "+++++-++++",
            "++------++",
            "+++++-++++",
            "+++++-++++"
        ),
        words = "LONDON;DELHI;ICELAND;ANKARA",
    )

    println(result.joinToString(""))
}

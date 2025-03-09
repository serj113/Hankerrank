import java.lang.StringBuilder

fun main() {
    val result = thirdSolution("CABABD")
    println("Result $result")
}

var result = ""

fun solution(s: String): String {
    
}

fun thirdSolution(s: String): String {
    val builder = StringBuilder()
    var i = 0
    while (i < s.length) {
        when {
            (i != s.length - 1 && s[i] == 'A' && s[i + 1] == 'B') ||
                    (i != s.length - 1 && s[i] == 'B' && s[i + 1] == 'A') ||
                    (i != s.length - 1 && s[i] == 'C' && s[i + 1] == 'D') ||
                    (i != s.length - 1 && s[i] == 'D' && s[i + 1] == 'C') -> {
                i += 2
            }

            else -> {
                builder.append(s[i])
                i++
            }
        }
    }
    val built = builder.toString()
    return if (s.length == built.length) {
        s
    } else thirdSolution(built)
}
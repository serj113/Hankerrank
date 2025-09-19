import kotlin.math.max

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    println(solution(10, 21))
}

fun solution(A: Int, B: Int): Int {
    return getSide(max(A,B), A, B)
}

fun getSide(side: Int, A: Int, B: Int): Int {
    if (A + B < 4 || side == 0) return 0
    if (A + B == 4) return 1

    val aSide = A / side
    val bSide = B / side

    val result = if (aSide + bSide >= 4) {
        side
    } else 0

    return max(getSide(side - 1, A, B), result)
}
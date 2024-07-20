fun main() {
    val result = solution(
        intArrayOf(
            7,-5,-5,-5,7,-1,-7
        )
    )
    println("Result $result")
}

fun solution(A: IntArray): Int {
    if (A.size <= 2) return A.size
    val odd = A.first()
    val even = A[1]
    var count = 2
    var i = 2
    while (i < A.size) {
        val compare = if (i % 2 == 1) {
            even
        } else odd
        if (A[i] != compare) {
            i = A.size
        } else {
            count++
            i++
        }
    }
    return if (count == A.size) {
        count
    } else Math.max(count, solution(A.takeLast(A.size-1).toIntArray()))
}
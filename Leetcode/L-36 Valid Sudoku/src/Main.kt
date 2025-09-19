fun main() {
//    println(
//        Solution()
//            .isValidSudoku(
//                arrayOf(
//                    charArrayOf('5','3','.','.','7','.','.','.','.'),
//                    charArrayOf('6','.','.','1','9','5','.','.','.'),
//                    charArrayOf('.','9','8','.','.','.','.','6','.'),
//                    charArrayOf('8','.','.','.','6','.','.','.','3'),
//                    charArrayOf('4','.','.','8','.','3','.','.','1'),
//                    charArrayOf('7','.','.','.','2','.','.','.','6'),
//                    charArrayOf('.','6','.','.','.','.','2','8','.'),
//                    charArrayOf('.','.','.','4','1','9','.','.','5'),
//                    charArrayOf('.','.','.','.','8','.','.','7','9'),
//                )
//            )
//    )
    println(
        Solution()
            .isValidSudoku(
                arrayOf(
                    charArrayOf('8','3','.','.','7','.','.','.','.'),
                    charArrayOf('6','.','.','1','9','5','.','.','.'),
                    charArrayOf('.','9','8','.','.','.','.','6','.'),
                    charArrayOf('8','.','.','.','6','.','.','.','3'),
                    charArrayOf('4','.','.','8','.','3','.','.','1'),
                    charArrayOf('7','.','.','.','2','.','.','.','6'),
                    charArrayOf('.','6','.','.','.','.','2','8','.'),
                    charArrayOf('.','.','.','4','1','9','.','.','5'),
                    charArrayOf('.','.','.','.','8','.','.','7','9'),
                )
            )
    )
}

class Solution {
    private val collections = listOf(
        hashSetOf<Char>(),
        hashSetOf<Char>(),
        hashSetOf<Char>(),
        hashSetOf<Char>(),
        hashSetOf<Char>(),
        hashSetOf<Char>(),
        hashSetOf<Char>(),
        hashSetOf<Char>(),
        hashSetOf<Char>(),
    )
    private val columns = listOf(
        hashSetOf<Char>(),
        hashSetOf<Char>(),
        hashSetOf<Char>(),
        hashSetOf<Char>(),
        hashSetOf<Char>(),
        hashSetOf<Char>(),
        hashSetOf<Char>(),
        hashSetOf<Char>(),
        hashSetOf<Char>(),
    )
    private val rows = listOf(
        hashSetOf<Char>(),
        hashSetOf<Char>(),
        hashSetOf<Char>(),
        hashSetOf<Char>(),
        hashSetOf<Char>(),
        hashSetOf<Char>(),
        hashSetOf<Char>(),
        hashSetOf<Char>(),
        hashSetOf<Char>(),
    )

    private val checks = hashSetOf<Pair<Int, Int>>()

    fun isValidSudoku(board: Array<CharArray>): Boolean {
        return isValid(0, 0, board)
    }

    private fun isValid(x: Int, y: Int, board: Array<CharArray>): Boolean {
        if (x > 8 || y > 8) return true
        val region = getRegion(x, y)
        val pair = Pair(x, y)
        val value = board[y][x]
        if (!checks.contains(pair) && value != '.') {
            if (collections[region].contains(value) || columns[x].contains(value) || rows[y].contains(value)) {
                return false
            }

            collections[region].add(value)
            columns[x].add(value)
            rows[y].add(value)
            checks.add(pair)
        }

        return isValid(x + 1, y, board) && isValid(x, y + 1, board)
    }

    private fun getRegion(x: Int, y: Int): Int {
        return when {
            x in 0..2 && y in 0..2 -> 0
            x in 3..5 && y in 0..2 -> 1
            x in 6..8 && y in 0..2 -> 2
            x in 0..2 && y in 3..5 -> 3
            x in 3..5 && y in 3..5 -> 4
            x in 6..8 && y in 3..5 -> 5
            x in 0..2 && y in 6..8 -> 6
            x in 3..5 && y in 6..8 -> 7
            x in 6..8 && y in 6..8 -> 8

            else -> 0
        }
    }
}
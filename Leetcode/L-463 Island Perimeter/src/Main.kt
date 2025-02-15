import kotlin.contracts.contract

fun main() {
    println(
        Solution()
            .islandPerimeter(
                grid = arrayOf(
                    intArrayOf(1, 1),
                )
            )
    )
}

class Solution {
    fun islandPerimeter(grid: Array<IntArray>): Int {
        var counter = 0
        grid.forEachIndexed { i, row ->
            row.forEachIndexed { j, island ->
                if (island == 1) {
                    val top = i - 1
                    val left = j - 1
                    val right = j + 1
                    val bottom = i + 1
                    if (top < 0 || (top >= 0 && grid[top][j] == 0)) {
                        counter++
                    }
                    if (left < 0 || (left >= 0 && row[left] == 0)) {
                        counter++
                    }
                    if (right > row.lastIndex || (right <= row.lastIndex && row[right] == 0)) {
                        counter++
                    }
                    if (bottom > grid.lastIndex || (bottom <= grid.lastIndex && grid[bottom][j] == 0)) {
                        counter++
                    }
                }
            }
        }

        return counter
    }
}
fun main() {
    println(
        Solution()
            .largestIsland(
                grid = arrayOf(
                    intArrayOf(1, 1),
                    intArrayOf(1, 0),
                )
            )
    )
}

class Solution {

    private var parent = arrayOf<Array<Pair<Int, Int>>>()
    private var rank = arrayOf<IntArray>()
    private var max = 0
    private var lastIndex = 0

    private fun find(coordinate: Pair<Int, Int>): Pair<Int, Int> {
        if (parent[coordinate.first][coordinate.second] != coordinate) {
            parent[coordinate.first][coordinate.second] = find(parent[coordinate.first][coordinate.second])
        }
        return parent[coordinate.first][coordinate.second]
    }

    private fun union(first: Pair<Int, Int>, second: Pair<Int, Int>) {
        val i = find(first)
        val j = find(second)
        if (i.first == j.first && i.second == j.second) {
            return
        }
        if (rank[i.first][i.second] > rank[j.first][j.second]) {
            parent[j.first][j.second] = i
            rank[i.first][i.second] += rank[j.first][j.second]
            max = maxOf(max, rank[i.first][i.second])
        } else {
            parent[i.first][i.second] = j
            rank[j.first][j.second] += rank[i.first][i.second]
            max = maxOf(max, rank[j.first][j.second])
        }
    }

    private fun tryMax(grid: Array<IntArray>, x: Int, y: Int) {
        val map = hashMapOf<Pair<Int, Int>, Int>()
        if (x > 0 && grid[x - 1][y] == 1) {
            val neighbor = Pair(x - 1, y)
            val root = find(neighbor)
            map[root] = rank[root.first][root.second]
        }
        if (x < lastIndex && grid[x + 1][y] == 1) {
            val neighbor = Pair(x + 1, y)
            val root = find(neighbor)
            map[root] = rank[root.first][root.second]
        }
        if (y > 0 && grid[x][y - 1] == 1) {
            val neighbor = Pair(x, y - 1)
            val root = find(neighbor)
            map[root] = rank[root.first][root.second]
        }
        if (y < lastIndex && grid[x][y + 1] == 1) {
            val neighbor = Pair(x, y + 1)
            val root = find(neighbor)
            map[root] = rank[root.first][root.second]
        }
        var tempMax = 0
        map.values.forEach {
            tempMax += it
        }

        max = maxOf(max, (tempMax + 1))
    }

    fun largestIsland(grid: Array<IntArray>): Int {
        if (grid.size == 1) return 1
        lastIndex = grid.lastIndex
        parent = Array(grid.size) { x ->
            Array(grid.size) { y ->
                Pair(x, y)
            }
        }
        rank = Array(grid.size) {
            IntArray(grid.size) { 1 }
        }
        var allZero = true
        for (x in 0..lastIndex) {
            for (y in 0..lastIndex) {
                if (grid[x][y] == 1) {
                    allZero = false
                }
                if (x > 0 && grid[x][y] == 1 && grid[x - 1][y] == 1) {
                    union(Pair(x, y), Pair(x - 1, y))
                }
                if (y > 0 && grid[x][y] == 1 && grid[x][y - 1] == 1) {
                    union(Pair(x, y), Pair(x, y - 1))
                }
            }
        }

        if (allZero) return 1
        for (x in 0..lastIndex) {
            for (y in 0..lastIndex) {
                if (grid[x][y] == 0) {
                    tryMax(grid, x, y)
                }
            }
        }

        return max
    }
}
fun main() {
    println(
        Solution()
            .findCircleNum(
                isConnected = arrayOf(
                    intArrayOf(1, 0, 0, 1), intArrayOf(0, 1, 1, 0), intArrayOf(0, 1, 1, 1), intArrayOf(1, 0, 1, 1),
                ),
            )
    )
}

class Solution {
    private var parent = intArrayOf()
    private var rank = intArrayOf()
    private var count = 0

    private fun find(node: Int): Int {
        if (node != parent[node]) {
            parent[node] = find(parent[node])
        }
        return parent[node]
    }

    private fun union(x: Int, y: Int) {
        val i = find(x)
        val j = find(y)
        if (i == j) {
            return
        }
        if (rank[j] > rank[i]) {
            parent[i] = j
        } else if (rank[j] < rank[i]) {
            parent[j] = i
        } else {
            parent[j] = i
            rank[i] += 1
        }
        count--
    }

    fun findCircleNum(isConnected: Array<IntArray>): Int {
        parent = IntArray(isConnected.size) { it }
        rank = IntArray(isConnected.size) { 1 }
        count = isConnected.size
        isConnected.forEachIndexed { i, connections ->
            connections.forEachIndexed { j, connected ->
                if (i != j && connected == 1) {
                    union(i, j)
                }
            }
        }

        return count
    }
}
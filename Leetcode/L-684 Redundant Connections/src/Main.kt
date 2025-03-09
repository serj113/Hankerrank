fun main() {
    Solution()
        .findRedundantConnection(
            edges = arrayOf(
                intArrayOf(
                    1, 2,
                ),
                intArrayOf(
                    1, 3,
                ),
                intArrayOf(
                    3, 4
                ),
                intArrayOf(
                    1, 4
                ),
                intArrayOf(
                    1, 5
                ),
            )
        )
        .forEach {
            print("$it ")
        }
}

class Solution {
    private var parent = hashMapOf<Int, Int>()
    private var rank = hashMapOf<Int, Int>()
    private var redundant = intArrayOf()

    private fun find(node: Int): Int {
        if (node != parent[node]) {
            parent[node] = find(parent[node] ?: node)
        }
        return parent[node] ?: node
    }

    private fun union(x: Int, y: Int) {
        val i = find(x)
        val j = find(y)
        if (i == j) {
            redundant = intArrayOf(x, y)
            return
        }
        if ((rank[i] ?: 1) > (rank[j] ?: 1)) {
            parent[j] = i
        } else if ((rank[i] ?: 1) < (rank[j] ?: 1)) {
            parent[i] = j
        } else {
            parent[j] = i
            rank[i] = (rank[i] ?: 1) + 1
        }
    }

    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        edges.forEach { connection ->
            connection.forEach { node ->
                if (!parent.containsKey(node)) {
                    parent[node] = node
                    rank[node] = 1
                }
            }
            union(connection.first(), connection.last())
        }

        return redundant
    }
}
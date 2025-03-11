fun main() {

}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    private val sums = mutableListOf<Long>()
    private val counts = mutableListOf<Int>()
    fun averageOfLevels(root: TreeNode?): DoubleArray {
        countLevels(
            root = root,
            level = 0,
        )

        val result = DoubleArray(sums.size)
        for (i in sums.indices) {
            result[i] = sums[i].div(counts[i].toDouble())
        }

        return result
    }

    fun countLevels(root: TreeNode?, level: Int) {
        if (root == null) return
        if (sums.getOrNull(level) == null) {
            sums.add(root.`val`.toLong())
            counts.add(1)
        } else {
            sums[level] += root.`val`.toLong()
            counts[level] += 1
        }

        countLevels(root.left, level + 1)
        countLevels(root.right, level + 1)
    }
}
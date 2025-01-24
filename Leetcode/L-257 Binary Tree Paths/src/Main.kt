fun main() {

}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun binaryTreePaths(root: TreeNode?): List<String> {
        if (root == null) return listOf()
        val left = root.left?.let {
            binaryTreePaths(it)
        } ?: listOf()
        val right = root.right?.let {
            binaryTreePaths(it)
        } ?: listOf()

        val all = left + right
        val result = if (all.isNotEmpty()) {
            all.map { each ->
                "${root.`val`}->$each"
            }
        } else listOf("${root.`val`}")

        return result
    }
}
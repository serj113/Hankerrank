fun main() {

}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun countNodes(root: TreeNode?): Int {
        if (root == null) return 0
        val left = root.left?.let {
            countNodes(it)
        } ?: 0
        val right = root.right?.let {
            countNodes(it)
        } ?: 0

        return 1 + left + right
    }
}
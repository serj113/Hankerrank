fun main() {

}

class TreeNode(var `val`: Int, var left: TreeNode? = null, var right: TreeNode? = null)

class Solution {
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0
        return 1 + maxDepth(root.left).coerceAtLeast(maxDepth(root.right))
    }
}
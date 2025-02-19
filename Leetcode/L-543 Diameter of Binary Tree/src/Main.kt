fun main() {

}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    private var result = Int.MIN_VALUE

    fun diameterOfBinaryTree(root: TreeNode?): Int {
        longestTree(root)
        return result
    }

    private fun longestTree(root: TreeNode?): Int {
        if (root == null) return 0
        val left = longestTree(root.left)
        val right = longestTree(root.right)
        result = Math.max(result, left + right)
        return 1 + Math.max(left, right)
    }
}
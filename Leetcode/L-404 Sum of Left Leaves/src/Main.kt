fun main() {

}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {

    private fun isLeaf(root: TreeNode?): Boolean {
        return root != null && root.left == null && root.right == null
    }

    fun sumOfLeftLeaves(root: TreeNode?): Int {
        if (root == null) return 0
        var result = 0
        if (isLeaf(root.left)) {
            result += root.left?.`val` ?: 0
        }

        return result + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right)
    }
}
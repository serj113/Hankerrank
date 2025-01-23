fun main() {

}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) return null
        val left = root.left?.let {
            invertTree(it)
        }
        val right = root.right?.let {
            invertTree(it)
        }

        root.left = right
        root.right = left
        return root
    }
}
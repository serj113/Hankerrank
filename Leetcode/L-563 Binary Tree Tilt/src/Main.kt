fun main() {

}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    private var result = 0

    fun findTilt(root: TreeNode?): Int {
        tilt(root)
        return result
    }

    fun tilt(root: TreeNode?): Int {
        if (root == null) return 0

        val left = tilt(root.left)
        val right = tilt(root. right)

        result += Math.abs(left - right)

        return root.`val` + left + right
    }
}
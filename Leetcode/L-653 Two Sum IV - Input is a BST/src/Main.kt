fun main() {

}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    private var target = 0
    private val set = hashSetOf<Int>()

    fun findTarget(root: TreeNode?, k: Int): Boolean {
        target = k
        return findTarget(root)
    }

    fun findTarget(root: TreeNode?): Boolean {
        if (root == null) return false
        return if (set.contains(target - root.`val`)) {
            true
        } else {
            set.add(root.`val`)
            findTarget(root.left) || findTarget(root.right)
        }
    }
}
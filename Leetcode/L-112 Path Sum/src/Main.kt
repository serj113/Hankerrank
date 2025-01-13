fun main() {
    println(
        Solution()
            .minDepth(
                root = TreeNode(
                    `val` = 2,
                    left = null,
                    right = TreeNode(
                        `val` = 3,
                        left = null,
                        right = TreeNode(
                            `val` = 4,
                            left = null,
                            right = TreeNode(
                                `val` = 5,
                                left = null,
                                right = TreeNode(
                                    `val` = 6,
                                ),
                            ),
                        )
                    ),
                )
            )
    )
}

class TreeNode(var `val`: Int, var left: TreeNode? = null, var right: TreeNode? = null)

class Solution {
    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        if (root == null) return false
        if (root.left == null && root.right == null) return root.`val` == targetSum
        return hasPathSum(root.left, targetSum - root.`val`) || hasPathSum(root.right, targetSum - root.`val`)
    }

    fun minDepth(root: TreeNode?): Int {
        if (root == null) return 0
        val value = if (root.left != null || root.right != null) {
            val left = root.left?.let {
                minDepth(it)
            } ?: Int.MAX_VALUE
            val right = root.right?.let {
                minDepth(it)
            } ?: Int.MAX_VALUE
            Math.min(left, right)
        } else 0
        return 1 + value
    }
}
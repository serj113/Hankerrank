fun main() {
    println(
        Solution()
            .isSameTree(
                p = TreeNode(
                    `val` = 1,
                    left = TreeNode(
                        `val` = 2,
                    ),
                    right = TreeNode(
                        `val` = 3,
                    ),
                ),
                q = TreeNode(
                    `val` = 1,
                    left = TreeNode(
                        `val` = 2,
                    ),
                    right = TreeNode(
                        `val` = 3,
                    ),
                ),
            )
    )
}

class TreeNode(var `val`: Int, var left: TreeNode? = null, var right: TreeNode? = null)

class Solution {
    fun isSymmetric(root: TreeNode?): Boolean {
        return isSameTree(root?.left, root?.right)
    }

    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null) return true
        return isSameTree(p?.right, q?.left) && p?.`val` == q?.`val` && isSameTree(p?.left, q?.right)
    }
}
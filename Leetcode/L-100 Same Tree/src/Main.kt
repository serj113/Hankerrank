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
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null) return true
        return isSameTree(p?.left, q?.left) && p?.`val` == q?.`val` && isSameTree(p?.right, q?.right)
    }
}
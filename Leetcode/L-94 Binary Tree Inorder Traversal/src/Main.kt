fun main() {

}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Producer {
    fun build(
        list: List<Int?>
    ): TreeNode {
        for () {

        }
    }
}

class Solution {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        root?.left?.let {
            result.addAll(inorderTraversal(it))
        }
        root?.`val`?.let {
            result.add(it)
        }
        root?.right?.let {
            result.addAll(inorderTraversal(it))
        }

        return result
    }
}
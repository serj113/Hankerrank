fun main() {
    val li = ListNode(1).apply {
        next = ListNode(1).apply {
            next = ListNode(2)
        }
    }

    Solution().deleteDuplicates(li)

    println(li.getChainValues())
}

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.\
 */

class ListNode(var `val`: Int) {
    var next: ListNode? = null

    fun getChainValues(): String {
        var result = "${this.`val`}"
        this.next?.let {
            result += " ${it.`val`}"
        }
        return result
    }
}

class Solution {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        if (head?.`val` != null && head.next?.`val` != null && head.`val` == head.next?.`val`) {
            head.next = head.next?.next
            deleteDuplicates(head)
        } else {
            head?.next?.let {
                deleteDuplicates(it)
            }
        }
        return head
    }
}
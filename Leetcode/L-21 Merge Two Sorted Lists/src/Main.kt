fun main() {
    val list1 = ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(4)
        }
    }
    val list2 = ListNode(1).apply {
        next = ListNode(3).apply {
            next = ListNode(4)
        }
    }

    val list = Solution().mergeTwoLists(list1, list2)

    println(list?.getChainValues())
}

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 */
class ListNode(var `val`: Int) {
    var next: ListNode? = null

    fun getChainValues(): String {
        var result = "${this.`val`}"
        this.next?.let {
            result += " ${it.getChainValues()}"
        }
        return result
    }
}

class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var head: ListNode? = null
        if (list1 != null && list2 != null) {
            if (list1.`val` <= list2.`val`) {
                head = list1
                head.next = mergeTwoLists(list1.next, list2)
            } else {
                head = list2
                head.next = mergeTwoLists(list1, list2.next)
            }
        } else if (list1 != null && list2 == null) {
            head = list1
            head.next = mergeTwoLists(list1.next, null)
        } else if (list2 != null) {
            head = list2
            head.next = mergeTwoLists(null, list2.next)
        }

        return head
    }
}
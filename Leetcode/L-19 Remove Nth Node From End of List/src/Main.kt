fun main() {

}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val list = mutableListOf<ListNode?>()
        var node = head
        while (node != null) {
            list.add(node)
            node = node.next
        }

        val target = list.size - n
        if (target == 0) {
            return head?.next
        }

        list[target - 1]?.next = list[target]?.next

        return head
    }
}
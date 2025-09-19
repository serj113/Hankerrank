fun main() {

}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun swapPairs(head: ListNode?): ListNode? {
        if (head?.next == null) return head
        val doubleNext = head.next?.next
        var tempHead = head
        tempHead = head.next
        tempHead.next = head
        tempHead.next?.next = swapPairs(doubleNext)

        return tempHead
    }
}
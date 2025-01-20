fun main() {

}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        if (head == null) return null
        var result = head
        head.next = removeElements(head.next, `val`)
        if (head.`val` == `val`) {
            result = head.next
        }

        return result
    }
}
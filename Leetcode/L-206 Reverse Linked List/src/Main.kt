fun main() {

}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}
// A B C
class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        var result = head
        var cur = head?.next
        result?.next = null
        while (cur != null) {
            val temp = cur
            cur = cur.next
            temp.next = result
            result = temp
        }

        return result
    }
}
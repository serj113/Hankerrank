fun main() {

}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    private var remain = 0

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null && l2 == null && remain == 0) return null
        var value = (l1?.`val` ?: 0) + (l2?.`val` ?: 0) + remain
        remain = value / 10
        if (value >= 10) {
            value -= 10
        }
        val result = ListNode(value)
        result.next = addTwoNumbers(l1?.next, l2?.next)

        return result
    }
}
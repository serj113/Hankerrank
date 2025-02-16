fun main() {
    println(
        Solution()
            .findComplement(1)
    )
}

class Solution {
    fun findComplement(num: Int): Int {
        return num.xor('1'.toString().repeat(32 - Integer.numberOfLeadingZeros(num)).toInt(2))
    }
}
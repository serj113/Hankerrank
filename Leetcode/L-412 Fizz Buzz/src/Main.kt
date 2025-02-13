fun main() {
    println(
        Solution()
            .fizzBuzz(3)
    )
}

class Solution {
    fun fizzBuzz(n: Int): List<String> {
        val result = mutableListOf<String>()
        for (i in 1..n) {
            var temp = ""
            if (i % 3 == 0) {
                temp += "Fizz"
            }
            if (i % 5 == 0) {
                temp += "Buzz"
            }
            if (temp.isEmpty()) {
                temp += i.toString()
            }

            result.add(temp)
        }

        return result
    }
}
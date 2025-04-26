fun main() {
    println(Solution().intToRoman(3749))
}

class Solution {
    fun intToRoman(num: Int): String {
        var result = ""
        var temp = num
        while (temp >= 1000) {
            result += "M"
            temp -= 1000
        }

        if (temp >= 900) {
            result += "CM"
            temp -= 900
        }
        if (temp >= 500) {
            result += "D"
            temp -= 500
        }

        if (temp >= 400) {
            result += "CD"
            temp -= 400
        }
        while (temp >= 100) {
            result += "C"
            temp -= 100
        }

        if (temp >= 90) {
            result += "XC"
            temp -= 90
        }
        if (temp >= 50) {
            result += "L"
            temp -= 50
        }

        if (temp >= 40) {
            result += "XL"
            temp -= 40
        }
        while (temp >= 10) {
            result += "X"
            temp -= 10
        }

        if (temp == 9) {
            result += "IX"
            temp -= 9
        }
        if (temp >= 5) {
            result += "V"
            temp -= 5
        }

        if (temp >= 4) {
            result += "IV"
            temp -= 4
        }

        while (temp >= 1) {
            result += "I"
            temp -= 1
        }

        return result
    }
}
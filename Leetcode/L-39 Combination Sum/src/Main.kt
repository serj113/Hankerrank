fun main() {
    Solution()
        .combinationSum(
            candidates = intArrayOf(2, 3, 5),
            target = 7,
        )
        .forEach { line ->
            line.forEach {
                print("$it ")
            }
            println()
        }
}

class Solution {
    val set = hashSetOf<List<Int>>()
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        combination(
            line = listOf(),
            sum = 0,
            candidates = candidates,
            target = target
        )

        return set.toList()
    }

    private fun combination(line: List<Int>, sum: Int, candidates: IntArray, target: Int) {
        if (sum == target) {
            set.add(line)
            return
        }
        if (sum > target || candidates.isEmpty()) return

        candidates.forEachIndexed { index, item ->
            combination(
                line = line.toMutableList().apply {
                    add(item)
                },
                sum = sum + item,
                candidates = candidates.copyOfRange(index, candidates.size),
                target = target,
            )
        }
    }
}
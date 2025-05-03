fun main() {
    Solution()
        .combinationSum2(
            candidates = intArrayOf(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1),
            target = 30,
        )
        .forEach { line ->
            line.forEach {
                print("$it ")
            }
            println()
        }
}

class Solution {
    private val set = hashSetOf<List<Int>>()

    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        combination(
            sum = 0,
            line = listOf(),
            start = 0,
            candidates = candidates.sortedArray(),
            target = target,
        )

        return set.toList()
    }

    private fun combination(sum: Int, line: List<Int>, start: Int, candidates: IntArray, target: Int) {
        if (sum == target) {
            set.add(line)
            return
        }
        if (sum > target || start > candidates.lastIndex) {
            return
        }

        for (i in start..candidates.lastIndex) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue
            }
            combination(
                sum = sum + candidates[i],
                line = line.toMutableList().apply {
                    add(candidates[i])
                },
                start = i + 1,
                candidates = candidates,
                target = target,
            )
        }
    }
}
import java.util.Queue
import java.util.Stack

fun main() {
    println("Hello World!")
}

class Solution {
    private var account = hashMapOf<String, String>()
    private var parent = hashMapOf<String, String>()
    private var emails = hashMapOf<String, MutableList<String>>()

    fun accountsMerge(accounts: List<List<String>>): List<List<String>> {
        accounts.forEach {
            account[it[1]] = it.first()
            val temp = mutableListOf<String>()
            var root = it[1]
            for (i in 1..it.lastIndex) {
                if (parent.containsKey(it[i])) {
                    root = parent[it[i]]!!
                } else {
                    temp.add(it[i])
                }
            }
            emails[root]?.let { existings ->
                temp.addAll(existings)
            }
            emails[root] = temp
        }

        val result = mutableListOf<List<String>>()
        account.forEach { entry ->
            emails[entry.key]?.let {
                val temp = mutableListOf(entry.value)
                temp.addAll(it.sorted())
                result.add(temp)
            }
        }
        return result
    }
}
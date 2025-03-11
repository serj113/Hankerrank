//fun main() {
//    val prices = intArrayOf(10, 5, 4, 7, 9, 12, 6, 2, 10)
//    println(maxProfit(prices)) // Output: 4
//}

data class Person(val name: String, val age: Int)

//fun main() {
//    val person = Person("Alice", 20)
//    val hashmap = hashMapOf(person to 1)
//
//    val updatedPerson = person.copy(age = 21)
//    println(hashmap[updatedPerson])
//}

//fun main() = runBlocking {
//    var counter = 0
//    val jobs = List(1000) {
//        launch(Dispatchers.IO) {
//            repeat(1000) {
//                counter++
//            }
//        }
//    }
//    jobs.forEach { it.join() }
//    println("Final counter value: $counter")
//}

// another input
// 10, 5, 4, 7, 9, 12, 6, 2, 10 -> output 20
// 10, 2, 12 -> output 10
// 2, 12, 10 -> output 10
// 1, 2, 3, 4 -> output 4

fun maxProfit(prices: IntArray): Int {
    var profit = 0
    val updated = prices.mapIndexed { index, price ->
        Pair(index, price)
    }.sortedWith { p1, p2 ->
        if (p1.second == p2.second) {
            p1.first - p2.first
        } else p2.second - p1.second
    }.toMutableList()
    var i = 0
    var j = updated.lastIndex
    while (i <= j) {
        if (updated[i].second > updated[j].second && updated[i].first > updated[j].first) {
            profit += updated[i].second - updated[j].second
            updated.removeAt(j)
            updated.removeAt(i)
            j = updated.lastIndex
        } else if (i == j) {
            i++
            j = updated.lastIndex
        } else {
            j--
        }
    }
    return profit
}

//fun maxProfit(prices: IntArray): Int {
//    var profit = 0
//    val queue = PriorityQueue<Int>()
//    prices.forEach { price ->
//        if (queue.isNotEmpty() && queue.peek() < price) {
//            profit += price - queue.poll()
//            queue.offer(price)
//        }
//        queue.offer(price)
//    }
//
//    return profit
//}
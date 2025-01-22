fun main() {
    val stack = MyStack()
    stack.push(1)
    println(stack.pop())
    println(stack.empty())
}

class MyStack() {

    private val stack = mutableListOf<Int>()

    fun push(x: Int) {
        stack.add(0, x)
    }

    fun pop(): Int {
        val result = stack[0]
        stack.removeAt(0)
        return result
    }

    fun top(): Int {
        val result = stack[0]
        return result
    }

    fun empty(): Boolean {
        return stack.isEmpty()
    }

}
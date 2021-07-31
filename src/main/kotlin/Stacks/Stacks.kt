package Stacks

class SimpleStack<K> {
    private var top: Node<K?>? = null
    private var bottom: Node<K?>? = null
    var size = 0

    private class Node<K>(var value: K, var next: Node<K>?)

    fun push(value: K?) {
        val node = Node(value, null)
        if (bottom == null) {
            top = node
            bottom = node
        } else {
            val pointer = top
            top = node
            top?.next = pointer
        }
        size++
    }

    fun pop(): K? {
        val value = top?.value
        if (top == null)
            return null
        val pointer = top
        top = null
        top = pointer?.next
        size--
        if (size == 0) {
            bottom = null
        }
        return value
    }

    fun peek(): K? {
        return top?.value
    }
}

fun main() {
    val stack = SimpleStack<String>()
    stack.push("google")
    stack.push("udemy")
    stack.peek()
    println(stack.pop())
    println(stack.pop())
}
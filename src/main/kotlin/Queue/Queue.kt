package Queue

class SimpleQueue<K> {
    private var first: Node<K>? = null
    private var last: Node<K>? = null
    private var size = 0

    private class Node<K>(var value: K, var next: Node<K>?)

    fun enqueue(value: K) {
        val newNode = Node(value, null)
        if (first == null) {
            last = newNode
            first = newNode
            size++
        } else {
            last?.next = newNode
            last = newNode
            size++
        }
    }

    fun dequeue(): K? {
        if (last == null) {
            return null
        }
        val pointer = first
        first = null
        first = pointer?.next
        size--
        if (size == 0) {
            last = null
        }
        return pointer?.value
    }

    fun peek(): K? {
        return first?.value
    }
}

fun main() {
    val queue = SimpleQueue<String>()
    queue.enqueue("Akshay")
    queue.enqueue("Varun")
    queue.enqueue("Ashish")
    println(queue.peek())
    queue.dequeue()
    queue.dequeue()
    queue.dequeue()

}
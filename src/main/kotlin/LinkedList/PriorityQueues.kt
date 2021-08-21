package LinkedList

class SimplePriorityQueue<K> {
    private var first: Node<K>? = null
        get() = queueArray.get(0)
        set(value) {
            if (value != null) {
                queueArray.set(0, value)
            }
            field = value
        }
    private var last: Node<K>? = null
        get() = queueArray.get(queueArray.size - 1)
        set(value) {
            if (value != null) {
                queueArray.set(queueArray.size - 1, value)
            }
            field = value
        }
    private var queueArray: ArrayList<Node<K>> = ArrayList()
    private var size = 0

    private class Node<K>(var value: K, var priority: Int)

    fun enqueue(value: K, priority: Int) {
        val newNode = Node(value, priority)
        if (queueArray.isEmpty()) {
            queueArray.add(newNode)
            size++
        } else {
            var isAdded = false
            for (index in queueArray.indices) {
                if (queueArray[index].priority > newNode.priority) {
                    queueArray.add(index, newNode)
                    isAdded = true
                    size++
                    break
                }
            }
            if (!isAdded) {
                queueArray.add(newNode)
            }
        }
    }

    fun dequeue(): Boolean {
        return queueArray.remove(first)
    }

    fun peek(): K? {
        return first?.value
    }
}

fun main() {
    val queue = SimplePriorityQueue<String>()
    queue.enqueue("A", 1)
    queue.enqueue("D", 2)
    queue.enqueue("G", 3)
    queue.enqueue("B", 1)
    queue.enqueue("E", 2)
    queue.enqueue("H", 3)
    queue.enqueue("C", 1)
    queue.enqueue("F", 2)
    queue.enqueue("I", 3)
    queue.enqueue("J", 4)
    println(queue.dequeue())
    println(queue.dequeue())
    println(queue.dequeue())
    println(queue.peek())

}
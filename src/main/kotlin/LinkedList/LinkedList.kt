package LinkedList


class SimpleLinkedList<T>() {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    var length: Int = 0

    private class Node<T> constructor(var prev: Node<T>?, var item: T, var next: Node<T>?)

    fun add(element: T) {
        if (length == 0) {
            head = Node(null, element, null)
            tail = head
            length++
        } else {
            val node = Node(tail, element, null)
            tail?.next = node
            tail = node
            length++
        }
    }

    fun delete() {
        if (length > 0) {
            tail?.prev?.next = null
            tail = tail?.prev
            length--
        }
    }

    fun addAtPosition(position: Int, element: T) {
        if (position == 0) {
            val node = Node(null, element, head)
            head?.prev = node
            head = node
            length++
        } else if (position == length) {
            val node = Node(tail, element, null)
            tail?.next = node
            tail = node
            length++
        } else {
            val node = Node(null, element, null)
            var traverse = head
            for (i in 0 until position - 1) {
                traverse = traverse?.next
            }
            node.next = traverse?.next
            node.prev = traverse
            traverse?.next?.prev = node
            traverse?.next = node
            length++
        }
    }

    fun reverse() {
        var i = length - 1
        var traverse = tail
        while (i >= 0) {
            println(traverse?.item)
            traverse = traverse?.prev
            i--
        }
//      for singly linked list
//        var first = head
//        var second = first?.next
//        while (second?.next != null) {
//            val temp = second.next
//            first = second
//            second = temp
//        }
    }

}


fun main() {
    val linked = SimpleLinkedList<String>()
    linked.add("10")
    linked.add("11")
    linked.add("12")
    linked.add("13")
    linked.add("14")
    println(linked.length)
    linked.addAtPosition(1, "16")
    println(linked.length)
    linked.delete()
    println(linked.length)
    println("******** Reverese List *********")
    linked.reverse()
    println("********************************")
    println(linked.length)
}
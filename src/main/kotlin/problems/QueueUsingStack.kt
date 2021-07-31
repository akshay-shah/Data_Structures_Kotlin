package problems

import Stacks.SimpleStack

class MyQueue {
    private var firstStack = SimpleStack<Int>()
    private var secondStack = SimpleStack<Int>()
    private var size = 0

    fun enqueue(value: Int) {
        while (secondStack.size != 0) {
            firstStack.push(secondStack.pop())
        }
        firstStack.push(value)
    }

    fun dequeue(): Int? {
        while (firstStack.size != 0)
            secondStack.push(firstStack.pop())
        return secondStack.pop()
    }
}

fun main() {
    val queue = MyQueue()
    queue.enqueue(1)
    queue.enqueue(2)
    queue.enqueue(3)
    println(queue.dequeue())
    queue.enqueue(4)
    println(queue.dequeue())
    println(queue.dequeue())
    println(queue.dequeue())
    queue.enqueue(5)
    queue.enqueue(6)
    queue.enqueue(7)
    println(queue.dequeue())
    println(queue.dequeue())
    println(queue.dequeue())
}
package BinarySearchTrees


class SimpleBinarySearchTree {

    private var root: Node? = null

    private class Node(var value: Int, var left: Node? = null, var right: Node? = null)

    fun insert(value: Int) {
        val newNode = Node(value, null, null)
        if (root == null) {
            root = newNode
        } else {
            var current = root
            while (true) {
                if (current!!.value < value) {
                    if (current.right != null) {
                        current = current.right
                    } else {
                        current.right = newNode
                        break
                    }
                } else {
                    if (current.left != null) {
                        current = current.left
                    } else {
                        current.left = newNode
                        break
                    }
                }
            }
        }
    }

    fun lookUp(value: Int): Any {
        var current = root
        while (current != null) {
            current = when {
                current.value > value -> current.left
                current.value < value -> current.right
                else -> return true
            }
        }
        return false
//            while (true) {
//                if (value == current!!.value) {
//                    return true
//                } else if (value < current.value && current.left != null) {
//                    current = current.left
//                    continue
//                } else if (value > current.value && current.right != null) {
//                    current = current.right
//                    continue
//                } else {
//                    return false
//                }
//            }
    }
}

fun main() {
    val tree = SimpleBinarySearchTree()
    tree.insert(10)
    tree.insert(15)
    tree.insert(13)
    tree.insert(12)
    tree.insert(1)
    tree.insert(5)
    println(tree.lookUp(15))
    println(tree.lookUp(20))
    println(tree.lookUp(1))
}
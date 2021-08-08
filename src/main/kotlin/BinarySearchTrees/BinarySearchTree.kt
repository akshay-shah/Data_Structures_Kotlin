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

    fun lookUp(value: Int): Boolean {
        var current = root
        while (current != null) {
            current = when {
                current.value > value -> current.left
                current.value < value -> current.right
                else -> return true
            }
        }
        return false
    }

    fun remove(value: Int): Boolean {
        if (this.root == null) {
            return true
        }
        var current = this.root
        var previousNode = this.root // node before the removing element
        var parentNode: Node? = null // node before the replacing element
        // while current is not null
        while (current != null) {
            when {
                value < current.value -> {
                    // go left
                    previousNode = current
                    current = current.left
                }
                value > current.value -> {
                    // go right
                    previousNode = current
                    current = current.right
                }
                else -> {
                    //if leaf node
                    if (current.right == null && current.left == null) {
                        current = null
                        return true
                    } else if (value >= root!!.value) {
                        //element in right sub tree
                        if (current.right != null) {
                            var traversalNode = current.right // node to traverse to the extreme elements

                            parentNode = current.right
                            // traverse to inorder successor and replace with current node
                            while (traversalNode?.left != null) {
                                parentNode = traversalNode
                                traversalNode = traversalNode.left
                            }
                            if (parentNode?.left == null) {
                                parentNode?.right = traversalNode?.right
                            } else {
                                parentNode.left = traversalNode?.right
                                traversalNode?.right = null
                                traversalNode?.left = current.left
                                traversalNode?.right = current.right
                            }
                            current = null
                            previousNode?.right = traversalNode
                            if (value == root!!.value) { // if element is root replace with traversal
                                root = traversalNode
                            }
                            return true
                        } else {
                            previousNode?.right = current.left // if tree is a right only tree
                            current = null
                            return true
                        }
                    } else {
                        // element is in left subtree
                        if (current.right != null) {
                            var traversalNode = current.right // node to traverse to the extreme elements
                            parentNode = current.left
                            // traverse to inorder successor and replace with current node
                            while (traversalNode?.left != null) {
                                parentNode = traversalNode
                                traversalNode = traversalNode.left
                            }
                            parentNode?.left = traversalNode?.right
                            traversalNode?.right = null
                            traversalNode?.left = current.left
                            traversalNode?.right = current.right
                            current = null
                            previousNode?.left = traversalNode
                            return true
                        } else {
                            previousNode?.left = current.left // if tree is a left tree
                            current = null
                            return true
                        }
                    }

                }

            }
        }
        return false
    }
}

fun main() {
    val tree = SimpleBinarySearchTree()
    tree.insert(20)
    tree.insert(15)
    tree.insert(25)
    tree.insert(10)
    tree.insert(17)
    tree.insert(21)
    tree.insert(30)
    tree.insert(5)
    tree.insert(13)
    tree.insert(16)
    tree.insert(18)
    tree.insert(24)
    tree.insert(27)
    tree.insert(40)
    tree.insert(19)
    tree.insert(1)
    tree.insert(9)
    tree.insert(12)
    tree.insert(22)
    tree.insert(26)
    tree.insert(28)
    tree.insert(35)
    tree.insert(37)
    tree.insert(42)
//    tree.insert(37)

//    tree.insert(50)
//    tree.insert(40)
//    tree.insert(30)
//    tree.insert(20)
//    tree.insert(10)
//    tree.insert(60)
//    tree.insert(70)
//    tree.insert(80)
//    tree.insert(90)
//    tree.insert(100)
//    tree.remove(24)
//    tree.remove(30)
    tree.remove(20)

//    20, 15, 25, 10, 17, 21, 30, 5, 13, 16, 18, 24, 27, 40, 19, 1, 9, 12, 22, 26, 28, 35, 42, 37
//    50,40,30,20,10,60,70,80,90,100
}
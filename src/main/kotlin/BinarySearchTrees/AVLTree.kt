package BinarySearchTrees


class SimpleAVLTree {

    private var root: Node? = null

    data class Node(var key: Int, var height: Int = 1, var left: Node? = null, var right: Node? = null)

    fun height(node: Node?): Int {
        return node?.height ?: 0
    }

    fun max(a: Int, b: Int): Int {
        return if (a > b) a else b
    }

    fun rightRotate(y: Node): Node {
        val x = y.left
        val T2 = x!!.right

        // Perform rotation
        x.right = y
        y.left = T2

        // Update heights
        y.height = max(height(y.left), height(y.right)) + 1
        x.height = max(height(x.left), height(x.right)) + 1

        // Return new root
        return x
    }

    fun leftRotate(x: Node): Node {
        val y = x.right
        val T2 = y!!.left

        // Perform rotation
        y.left = x
        x.right = T2

        //  Update heights
        x.height = max(height(x.left), height(x.right)) + 1
        y.height = max(height(y.left), height(y.right)) + 1

        // Return new root
        return y
    }

    fun getBalance(node: Node?): Int {
        return if (node == null) 0 else height(node.left) - height(node.right)
    }

    fun insert(node: Node?, key: Int): Node {

        /* 1.  Perform the normal BST insertion */
        if (node == null) return Node(key)
        if (key < node.key) node.left = insert(node.left, key) else if (key > node.key) node.right =
            insert(node.right, key) else  // Duplicate keys not allowed
            return node

        /* 2. Update height of this ancestor node */node.height = 1 + max(height(node.left),
            height(node.right))

        /* 3. Get the balance factor of this ancestor
              node to check whether this node became
              unbalanced */
        val balance = getBalance(node)

        // If this node becomes unbalanced, then there
        // are 4 cases Left Left Case
        if (balance > 1 && key < node.left!!.key) return rightRotate(node)

        // Right Right Case
        if (balance < -1 && key > node.right!!.key) return leftRotate(node)

        // Left Right Case
        if (balance > 1 && key > node.left!!.key) {
            node.left = leftRotate(node.left!!)
            return rightRotate(node)
        }

        // Right Left Case
        if (balance < -1 && key < node.right!!.key) {
            node.right = rightRotate(node.right!!)
            return leftRotate(node)
        }

        /* return the (unchanged) node pointer */return node
    }

    fun preOrder(node: Node?) {
        if (node != null) {
            print(node.key.toString() + " ")
            preOrder(node.left)
            preOrder(node.right)
        }
    }

}
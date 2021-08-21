package BinarySearchTrees

class SimpleTrie {

    private var root: TrieNode? = TrieNode(0, HashMap())

    private data class TrieNode(var wordEnd: Int = 0, var nodes: MutableMap<Char, TrieNode> = mutableMapOf())

    fun insert(word: String) {
        val charArray = word.toCharArray() // convert to char array
        var traversal = root
        charArray.forEachIndexed loop@{ index, char ->
            //search if char already exists in trie
            if (traversal?.nodes!!.isNotEmpty()) {
                if (traversal!!.nodes.contains(char)) {
                    //word was previously deleted update the wordend
                    if (index == charArray.size - 1 && traversal!!.nodes.get(char)?.wordEnd == 0) {
                        traversal!!.nodes.get(char)?.wordEnd = 1
                        return@loop
                    }
                    //char pr
                    traversal = traversal!!.nodes.get(char)
                    return@loop
                }
            }
            // if not check if it is last character and insert and update word end
            if (index == charArray.size - 1) {
                traversal!!.nodes.put(char, TrieNode(wordEnd = 1))
                traversal = traversal!!.nodes.get(char) // increment traversal to point to next char
            } else {
                // if not last character do not update wordend
                traversal!!.nodes.put(char, TrieNode(wordEnd = 0))
                traversal = traversal!!.nodes.get(char)
            }
        }
    }

    fun search(word: String): Boolean {
        val charArray = word.toCharArray()
        var traversal = root
        charArray.forEachIndexed loop@{ index, char ->
            if (traversal?.nodes!!.isNotEmpty() && traversal!!.nodes.contains(char)) {
                // if its last character and is wordend return true
                if (index == charArray.size - 1 && traversal?.nodes?.get(char)?.wordEnd == 1) {
                    return true
                } else {
                    // if not last character continue the search
                    traversal = traversal!!.nodes.get(char)
                }
                //move to next character if current char found
                return@loop
            }
            // else return false if word not found
            return false
        }
        // else return false if word not found
        return false
    }

    fun delete(word: String): Boolean {
        val charArray = word.toCharArray()
        var traversal = root
        charArray.forEachIndexed loop@{ index, char ->
            if (traversal?.nodes!!.isNotEmpty() && traversal!!.nodes.contains(char)) {
                // if its last character and is wordend return true
                if (index == charArray.size - 1 && traversal?.nodes?.get(char)?.wordEnd == 1) {
                    traversal?.nodes?.get(char)?.wordEnd = 0
                    return true
                } else {
                    traversal = traversal?.nodes?.get(char)
                    return@loop
                }
            }
            // else return false if word not found
            return false
        }
        // else return false if word not found
        return false
    }
}


//Complexity
//n size of node
//m size of word
//Insertion time O(m)
//Search time O(log n)
//Deletion time O(m)

fun main() {
    val trie = SimpleTrie()
    trie.insert("akshay")
    trie.insert("akshat")
    trie.insert("bcad")
    println(trie.search("akshay"))
    println(trie.search("baa"))
    println(trie.search("bcad"))
    println(trie.search("a"))
    println(trie.delete("bcad"))
    println(trie.insert("bcad"))
}
package HashTables

const val INITIAL_CAPACITY = 1 shl 4

class SimpleHashMap<K, V> internal constructor(size: Int = INITIAL_CAPACITY) {

    private val bucket = arrayOfNulls<Entry<K, V>>(size)
    var size = 0

    private class Entry<K, V> internal constructor(val key: K, var value: V, var next: Entry<K, V>?)

    fun put(key: K, value: V) {
        val entry = Entry(key, value, null)
        val hashCode = getHash(key)
        if (bucket[hashCode] == null) {
            bucket[hashCode] = entry
            size++
        } else {
            var tail = getTailNode(bucket[hashCode])
            tail?.next = entry
            size++
        }
    }

    fun get(key: K): V? {
        val hashCode = getHash(key)
        var node = bucket[hashCode]
        while (node != null) {
            if (node.key == key) {
                return node.value
            }
            node = node.next
        }
        return null
    }

    fun remove(key: K) {
        val hashCode = getHash(key)
        var node = bucket[hashCode]
        var previousNode = node
        while (node != null) {
            if (node.key == key) {
                if (node.next != null)
                    previousNode?.next = node.next
                else
                    previousNode?.next = null
                size--
                break
            }
            previousNode = node
            node = node.next
        }
    }

    private fun getHash(key: K): Int {
        return key.hashCode() % bucket.size
    }

    private fun getTailNode(entry: SimpleHashMap.Entry<K, V>?): Entry<K, V>? {
        var traverse = entry
        while (traverse?.next != null) {
            traverse = traverse.next
        }
        return traverse
    }


}

fun main() {
    val hashMap = SimpleHashMap<Int, Int>()
    for (i in 1..100) {
        hashMap.put(i, i * 10)
    }
    hashMap.remove(32)
    hashMap.remove(96)
    println(hashMap.get(101))
}
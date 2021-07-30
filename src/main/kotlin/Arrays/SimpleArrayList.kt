package Arrays

class SimpleArrayList(
    private var array: Array<String?> = arrayOfNulls(1),
    private var capacity: Int = 1,
    var length: Int = 0,
) {
    fun get(index: Int): String? {
        if (index < length)
            return array[index]
        else
            return null
    }

    fun add(item: String) {
        if (length == capacity) {
            val tempArray = arrayOfNulls<String>(2 * capacity)
            array.forEachIndexed { index, i ->
                tempArray[index] = i
            }
            array = tempArray
            capacity *= 2
        }
        array[length] = item
        length++
    }

    fun delete() {
        if (length > 0) {
            array[length - 1] = null
            length--
        }
    }

    fun delete(index: Int) {
        if (index < length) {
            for (i in index..length) {
                array[i] = array[i + 1]
            }
            length--
        }
    }

    override fun toString(): String {
        var string = ""
        array.forEach { it?.let { string += it } }
        return string
    }

}

fun main() {
    val array = SimpleArrayList()
    array.add("akshay")
    array.add("sandeep")
    array.add("monish")
    array.add("ashish")
    array.add("naidu")
    array.add("kothari")
    println(array.get(0))
    println(array.length)
    array.delete()
    println(array.toString())
    println(array.length)
    array.delete(0)
    array.delete(array.length)
    println(array.toString())
    println(array.length)
}
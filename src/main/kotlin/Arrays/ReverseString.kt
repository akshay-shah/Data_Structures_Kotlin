package Arrays

fun reverseString(string: String) {
    for (i in string.length - 1 downTo 0) {
        print(string[i])
    }
}

fun main() {
    reverseString("Hi my name is Akshay")
}
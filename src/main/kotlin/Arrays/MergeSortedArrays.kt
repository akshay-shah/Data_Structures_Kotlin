package Arrays

val firstList = intArrayOf()
val secondList = intArrayOf(0, 1, 2, 5, 6, 9)

fun mergeSortedArray(firstList: IntArray, secondList: IntArray): List<Int> {
    val sortedlist = mutableListOf<Int>()
    var i = 0
    var j = 0
    if (firstList.isNotEmpty() && secondList.isNotEmpty()) //Check if list not empty
        while (i < firstList.size && j < secondList.size) {
            if (firstList[i] < secondList[j]) { //Check if element in firstList smaller than secondList
                sortedlist.add(firstList[i]) //add element to a merged array
                if (i < firstList.size - 1) {
                    i += 1 //Increment counter until list size
                } else {
                    sortedlist.add(secondList[j])//when secondList has more elements than firstList
                    j += 1
                }
            } else if (firstList[i] > secondList[j]) { //Check if element in secondList smaller than firstList
                sortedlist.add(secondList[j])//add element to a merged array
                if (j < secondList.size - 1) {
                    j += 1//Increment counter until list size
                } else {
                    sortedlist.add(firstList[i]) //when firstList has more elements than secondList
                    i += 1
                }
            } else if (firstList[i] == secondList[j]) {//check if both equal
                sortedlist.add(firstList[i]) //add element to sorted array
                sortedlist.add(secondList[j]) //add element to sorted array
                i += 1
                j += 1
            }
        }
    else if (firstList.isEmpty()) { //when firstList is empty return secondList
        return secondList.toList()
    } else if (secondList.isEmpty()) { //when secondList is empty return firstList
        return firstList.toList()
    }
    return sortedlist

}

fun main() {
    println(mergeSortedArray(firstList, secondList).toString())
}
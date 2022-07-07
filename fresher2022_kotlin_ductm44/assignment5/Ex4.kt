package com.example.fresher2022_kotlin_ductm44.assignment5

fun inData(n: Int, arr: Array<String?>) {
    for (i in 0 until n) {
        print("a[$i] = ")
        val x: String = readLine()!!.toString()
        arr[i] = x
    }
}

fun main() {
    print("Enter number of array colors elements: ")
    val n = readLine()!!.toInt()
    var colors = arrayOfNulls<String>(n)
    inData(n, colors)

    print("\n\nEnter number of array colors2 elements: ")
    val n2 = readLine()!!.toInt()
    var colors2 = arrayOfNulls<String>(n2)
    inData(n2, colors2)

    var list = mutableListOf<String>()
    for (i in colors.indices) {
        list.add(colors[i].toString())
    }

    var list2 = mutableListOf<String>()
    for (i in colors2.indices) {
        list2.add(colors2[i].toString())
    }

    print("\nMerge list2: ")
    list = (list + list2) as MutableList<String>
    list2.clear()
    print(list)

    print("\nUppercase: ")
    list = list.map { x -> x.uppercase() } as MutableList<String>
    print(list)

    print("\nRemove elements in range [4,6]: ")
    if (list.size < 3) {
        try {
            list.subList(3, 5).clear()
        } catch (e: IndexOutOfBoundsException) {
            println("Out of Index. List has ${list.size} elements.")
        }
    }
    when (list.size) {
        4 -> {
            list.removeAt(3)
            print(list)
        }
        5 -> {
            list.subList(3, 5).clear()
            print(list)
        }
    }
    if (list.size > 5) {
        list.subList(3, 6).clear()
        print(list)
    }
    print("\nList reversed: ")
    print(list.reversed())

}

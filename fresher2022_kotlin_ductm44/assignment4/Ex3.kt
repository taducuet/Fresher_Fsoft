package com.example.fresher2022_kotlin_ductm44.assignment4

fun <T : Comparable<T>?> max(list: List<T>, begin: Int, end: Int): T {
    var begin: Int = begin
    var _max = list[begin]
    ++begin
    while (begin < end) {
        if (_max!! < list[begin]) _max = list[begin]
        ++begin
    }
    return _max
}

fun main() {
    val numbers: List<Int> = listOf(0, 2, 5, 9, 3, 1, 6, 10, 12)
    print("Enter begin index of range: ")
    var begin: Int = readLine()!!.toInt()
    print("Enter end index of range: ")
    var end: Int = readLine()!!.toInt()
    print("Max element in range [$begin, $end): ${max(numbers, begin, end)} ")
}



package com.example.fresher2022_kotlin_ductm44.assignment4

interface Properties<T> {
    fun test(x: T): Boolean
}

fun <T> countElement(c: Array<T>, p: Properties<T>): Int {
    var count = 0
    for (i in c) if (p.test(i)) count++
    return count
}

class Odd : Properties<Int> {
    override fun test(x: Int): Boolean {
        return x % 2 != 0
    }
}

class Prime : Properties<Int> {
    override fun test(x: Int): Boolean {
        if (x == 0 || x == 1) {
            return false
        }
        for (i in 2..x / 2) {
            if (x % i == 0)
                return false
        }
        return true
    }
}

fun main(args: Array<String>) {
    val input = arrayOf(1, 2, 3, 4, 5, 7, 13, 17, 21)
    val count = countElement<Int>(input, Odd())
    println("Number of odd integers = $count")

    val count2 = countElement<Int>(input, Prime())
    println("Number of prime integers = $count2")
}
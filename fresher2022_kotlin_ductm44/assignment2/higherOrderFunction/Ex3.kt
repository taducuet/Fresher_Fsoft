package com.example.fresher2022_kotlin_ductm44.assignment2.higherOrderFunction

fun main(){
    print("Enter number: ")
    var num: Int = readLine()!!.toInt()
    val sum = returnSum()
    print("Sum of integer that smaller than $num: ${sum(num)}")
}

fun returnSum(): ((Int) -> Int){
    return ::sum
}

fun sum(n: Int) :Int{
        if (n == 1) return 1
        return n + sum(n - 1)
}
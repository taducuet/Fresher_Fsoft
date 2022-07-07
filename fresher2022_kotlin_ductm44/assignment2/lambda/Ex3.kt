package com.example.fresher2022_kotlin_ductm44.assignment2.lambda

import com.example.fresher2022_kotlin_ductm44.assignment2.higherOrderFunction.sum

fun main(){
    print("Enter number: ")
    var num: Int = readLine()!!.toInt()

    val sum = lambda@ { num: Int ->
        if (num == 1) return@lambda 1
        return@lambda num + sum(num - 1)
    }

    print("Sum of integer that smaller than $num: ${sum(num)}")
}
package com.example.fresher2022_kotlin_ductm44.assignment2.higherOrderFunction

fun main(){
    print("Enter number: ")
    var num: Int = readLine()!!.toInt()
    val sumDigits = returnSumDigits()
    print("Sum of digits of number: ${sumDigits(num)}")
}

fun returnSumDigits(): ((Int) -> Int){
    return ::sumDigits
}

fun sumDigits (num: Int): Int{
    var temp = num
    var sum: Int = 0
    while(temp!= 0){
        sum += temp % 10
        temp /= 10
    }
    return sum
}
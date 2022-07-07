package com.example.fresher2022_kotlin_ductm44.assignment2.lambda

fun main(){
    print("Enter number: ")
    var num: Int = readLine()!!.toInt()

    val sumDigits = lambda@ { num: Int ->
        var temp = num
        var sum: Int = 0
        while(temp!= 0){
            sum += temp % 10
            temp /= 10
        }
        return@lambda sum
    }
    print("Sum of digits of number: ${sumDigits(num)}")
}
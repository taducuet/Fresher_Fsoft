package com.example.fresher2022_kotlin_ductm44.assignment2.lambda

fun main(){
    val checkPrime = lambda@ { num: Int ->
        if (num <= 1) return@lambda false
        else if (num == 2) return@lambda true
        else if (num %2 ==0) return@lambda false
        for (i in 2..num/2){
            if (num % i ==0)
                return@lambda false
        }
        return@lambda true
    }
    print("Enter number: ")
    var num: Int = readLine()!!.toInt()
    var flag: Boolean = false
    for (i in 2..num/2){
        if(checkPrime(i)){
            if(checkPrime(num-i)){
                print("Number can be expressed as sum of 2-prime numbers. \nPossible results: $num = $i + ${(num-i)} \n")
                flag = true
            }
        }
    }
    if(!flag) print("$num can not be expressed as sum of 2-prime numbers")

}
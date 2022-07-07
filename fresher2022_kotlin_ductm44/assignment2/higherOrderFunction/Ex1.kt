package com.example.fresher2022_kotlin_ductm44.assignment2.higherOrderFunction

fun main(){
    returnSumPrime {  }
}
fun checkPrime(num: Int): Boolean{
    if (num <= 1) return false
    else if (num == 2) return true
    else if (num %2 ==0) return false
    for (i in 2..num/2){
        if (num % i ==0)
            return false
    }
    return true
}

fun returnSumPrime( checkPrime: (Boolean) -> Unit) {
    print("Enter number: ")
    var num: Int = readLine()!!.toInt()
    var flag = false
    for (i in 2..num/2){
        if(checkPrime(i)){
            if(checkPrime(num-i)){
                print("Number can be expressed as sum of 2-prime numbers. \n Possible results: $num = $i + ${(num-i)} \n")
                flag = true
            }
        }
    }
    if(!flag) print("$num can not be expressed as sum of 2-prime numbers")
}

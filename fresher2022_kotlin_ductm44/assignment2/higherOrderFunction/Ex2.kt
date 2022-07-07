package com.example.fresher2022_kotlin_ductm44.assignment2.higherOrderFunction

fun main(){
    returnPrimeBetween {  }
}
fun returnPrimeBetween(checkPrime: (Boolean) -> Unit){
    val sb = StringBuilder()
    print("Enter number 1: ")
    var prime1: Int = readLine()!!.toInt()
    print("Enter number 2: ")
    var prime2: Int = readLine()!!.toInt()
    for (i in prime1+1 until prime2){
        if(checkPrime(i))
            sb.append("$i, ")
    }
    print("Prime numbers between $prime1 and $prime2: ${sb.substring(0,sb.length-2)}")
}

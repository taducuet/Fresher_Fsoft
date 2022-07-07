package com.example.fresher2022_kotlin_ductm44.assignment2.extensionFunction

fun main(){
    print("Enter number: ")
    val num: Int = readLine()!!.toInt()
    val hexStr = num.toHexString()
    print("Hexadecimal number: ")
    print(num.toHexString())

}

fun Int.toHexString(): String {
    return toString(16)
}




package com.example.fresher2022_kotlin_ductm44.assignment2.extensionFunction

fun main() {
    print("Enter Hexadecimal number: ")
    var hex = readLine()!!.toString()
    val result = hex.toBinaryString()
    print(result)
}

fun String.toBinaryString(): String {
    var dec = this.toInt(16)
    return dec.toString(2)
}


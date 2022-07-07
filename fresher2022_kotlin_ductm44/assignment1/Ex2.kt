package com.example.fresher2022_kotlin_ductm44.assignment1

fun main(){
    print("Enter 2-digit number: ")
    val num:Int = readLine()!!.toInt()
    if (num in 10..99) {
        print("Convert to Binary: ")
        println(cvtBinary(num))
        print("Convert to Hexadecimal: ")
        println(cvtHexadecimal(num))
    } else {
        print("Illegal. Please enter a 2-digit integer")
    }
}
fun cvtBinary(n: Int): String {
    var n = n
    val sb = StringBuilder()
    while (n > 0) {
        sb.append(n % 2)
        n /= 2
    }
    sb.reverse()
    return sb.toString()
}

fun cvtHexadecimal(n: Int): String {
    var n = n
    val sb = StringBuilder()
    while (n>0){
        when(n%16){
            10 -> sb.append("A")
            11 -> sb.append("B")
            12 -> sb.append("C")
            13 -> sb.append("D")
            14 -> sb.append("E")
            15 -> sb.append("F")
            else -> sb.append(n%16)
        }
        n /= 16
    }
    sb.reverse()
    return sb.toString()
}
package com.example.fresher2022_kotlin_ductm44.assignment5

fun division(num: Double, den: Double): Double {
    if (den == 0.0)
        throw Exception("Division is not valid. Denominator must unlike 0")
    else
        return num / den
}


fun main() {
    var num: Double = 0.0
    var den: Double = 0.0
    try {
        print("Enter number 1: ")
        num = readLine()!!.toDouble()
        print("Enter number 2: ")
        den = readLine()!!.toDouble()

    } catch (e: NumberFormatException) {
        println(e)
    }

    try{
        print("$num / $den = ${division(num,den)}")
    } catch (e: Exception){
        println(e.message)
    }


}
package com.example.fresher2022_kotlin_ductm44.assignment5

fun input(n: Int ,arr: IntArray){
    for (i in 0 until n) {
        print("a[$i] = ")
        val x: Int = readLine()!!.toInt()
        arr[i] = x
        if(arr[i]==100){
            for(k in 0..i){
                print("${arr[k]} ")
            }
            throw Exception("\nTerminated !")
        }
    }
}

fun main(){
    print("Enter number of array elements: ")
    val n = readLine()!!.toInt()
    val arr = IntArray(n)
    try{
        input(n,arr)
    } catch (e: Exception){
        println(e.message)
    }
}
package com.example.fresher2022_kotlin_ductm44.assignment1

fun main() {
    print("Enter number of array elements: ")
    val n: Int = readLine()!!.toInt()
    //create Array
    val arr = IntArray(n)
    for (i in 0 until n) {
        print("a[$i] = ")
        val x: Int = readLine()!!.toInt()
        arr[i] = x
    }
    var temp: Int
    for (i in 0 until n-1){
        for(j in i+1 until n){
            if(arr[i]>arr[j]){
                temp = arr[i]
                arr[i] = arr[j]
                arr[j] = temp
            }
        }
    }
    print("Sorted array: ")
    for (i in 0 until n){
        print(arr[i])
        print(" ")
    }
}
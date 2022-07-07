package com.example.fresher2022_kotlin_ductm44.assignment5

fun main(){
    val arr = arrayOf(1,2,3,4,5)
    try{
        print(arr[6])
    } catch (e: IndexOutOfBoundsException){
        print("Out of index")
    }

}
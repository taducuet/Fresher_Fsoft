package com.example.fresher2022_kotlin_ductm44.assignment4

fun <T> swap(a: Array<T>, i:Int, j: Int){
    val temp = a[i]
    a[i] = a[j]
    a[j] = temp
}
fun main(){
    val a: Array<Int> = arrayOf(0,1,2,3,4,5,6)
    swap(a,0,1)
    for (element in a)
        print("$element ")
    print("\n")

    val b = arrayOf("First", "Second", "Third", 0 ,1, 2)
    swap(b,0,4)
    for (element in b)
        print("$element ")
}

package com.example.fresher2022_kotlin_ductm44.assignment1

fun main() {
    print("Enter a string: ")
    var str: String = readLine()!!.toString()

    //trim() -> returns copy of string with leading and trailing space deleted
    str = str.trim().replace(" +".toRegex(), " ")

    val a: CharArray = str.toCharArray()

    //Count word
    var count = 1
    for(index in a.indices){
        if (a[index] == ' ')
            count++
    }
    println("Number of words: $count")

    //Capitalize the first letter of sentence
    if (a[0] != 32.toChar() && a[0] >= 97.toChar() && a[0] <= 122.toChar())
        a[0] = a[0] - 32
    else
        a[0] = a[0]
    for(i in 1 until str.length){
        //Capitalize letter after dot (ASCII: 46)
        if (a[i]==46.toChar() && a[i+2]!=32.toChar() && a[i+2] >= 97.toChar() && a[i+2] <= 122.toChar())
            a[i+2] = a[i+2]-32
    }
    print("Capitalize the first letter of sentence: ")
    print(a)
}



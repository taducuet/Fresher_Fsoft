package com.example.fresher2022_kotlin_ductm44.assignment1

fun main() {
    val sb = StringBuilder()
    for (i in 10..200) {
        if (i % 7 == 0 && i % 5 != 0) {
            sb.append("$i, ")
        }
    }
    print(sb.substring(0, sb.length -2))
}

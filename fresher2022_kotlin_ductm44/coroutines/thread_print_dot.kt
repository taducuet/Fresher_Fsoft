package com.example.fresher2022_kotlin_ductm44.coroutines

fun main(){
    val cal = Calculator()
    cal.start()
}

class Calculator : Thread() {
    override fun run() {
        repeat(100000) {
            Thread.sleep(5000L)
            print(".")
        }
    }
}
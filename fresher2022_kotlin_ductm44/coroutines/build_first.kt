package com.example.fresher2022_kotlin_ductm44.coroutines
import kotlinx.coroutines.*

fun main(){
    GlobalScope.launch { // chạy một coroutine trên background thread
        delay(1000L) // non-blocking coroutine bị delay 10s
        println("World,") // print từ World ra sau khi hết delay
    }
    println("Hello,") // main thread vẫn tiếp tục chạy xuống dòng code này trong khi coroutine vẫn đang bị delay 10s
    Thread.sleep(2000L) // block main thread 2s
    println("Kotlin")
}

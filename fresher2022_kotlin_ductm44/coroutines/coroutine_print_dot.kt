package com.example.fresher2022_kotlin_ductm44.coroutines

import kotlinx.coroutines.*

fun main() = runBlocking{
    repeat(100000){
        launch {
            delay(5000L)
            print(".")
        }
    }
}


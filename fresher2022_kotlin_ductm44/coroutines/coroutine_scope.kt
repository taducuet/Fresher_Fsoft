package com.example.fresher2022_kotlin_ductm44.coroutines

import kotlinx.coroutines.*

fun main() = runBlocking{
    launch {
        delay(200L)
        println("Task from runBlocking") //line code 1
    }
    coroutineScope {
        launch {
            delay(500L)
            println("Task from nested launch")
        }

        delay(60L)
        println("Task from coroutine scope")
    }
    println("Coroutine scope is over ")
}
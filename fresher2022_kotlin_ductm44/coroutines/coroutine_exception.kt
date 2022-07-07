package com.example.fresher2022_kotlin_ductm44.coroutines

import kotlinx.coroutines.*

fun main(){
    runBlocking {
        val deferred = GlobalScope.async {
            println("Throw exception from launch")
            throw ArithmeticException()
            println("Unreached")
        }
        deferred.await()
    }
}
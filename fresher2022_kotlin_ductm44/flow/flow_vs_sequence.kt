//package com.example.fresher2022_kotlin_ductm44.flow
//import kotlinx.coroutines.*
//import kotlinx.coroutines.flow.Flow
//import kotlinx.coroutines.flow.flow
//import kotlin.system.measureTimeMillis
//
////sequence
///*fun foo(): Sequence<Int> = sequence { // sequence builder
//    for (i in 1..3) {
//        Thread.sleep(1000)
//        yield(i) // yield next value
//    }
//}
//
//fun main() = runBlocking {
//    // Launch a concurrent coroutine to check if the main thread is blocked
//    launch {
//        println(Thread.currentThread().name)
//        for (k in 1..3) {
//            delay(1000)
//            println("I'm blocked $k")
//        }
//    }
//    val time = measureTimeMillis {
//        foo().forEach { value -> println(value) }
//    }
//    println("$time s")
//}*/
//
////flow
//fun foo(): Flow<Int> = flow {
//    // flow builder
//    for (i in 1..3) {
//        delay(1000)
//        emit(i) // emit next value
//    }
//}
//
//fun main() = runBlocking {
//    // Launch a concurrent coroutine to check if the main thread is blocked
//    launch {
//        println(Thread.currentThread().name)
//        for (k in 1..3) {
//            delay(900)
//            println("I'm not blocked $k")
//        }
//    }
//    // Collect the flow
//    val time = measureTimeMillis {
//        //foo().collect { value -> println(value) }
//    }
//    println("$time s")
//}
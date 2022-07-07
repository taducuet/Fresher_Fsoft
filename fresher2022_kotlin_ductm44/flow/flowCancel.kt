package com.example.fresher2022_kotlin_ductm44.flow
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

//flow can not be canceled when not in suspend
//fun fooCancel(): Flow<Int> = flow {
//    for (i in 1..3) {
//        delay(2000)
//        println("Emitting $i")
//        emit(i)
//    }
//}
//
//
//fun main() = runBlocking {
//    withTimeoutOrNull(5000) { // Timeout after 5s
//        fooCancel().collect { value -> println(value) }
//    }
//    println("Done")
//}

//Try using thread
fun fooSleep(): Flow<Int> = flow {
    for (i in 1..3) {
        Thread.sleep(2000)
        println("Emitting $i")
        emit(i)
    }
}

fun main() = runBlocking {
    withTimeout(1000) { // Timeout after 1s
        fooSleep().collect { value -> println(value) }
    }

    println("Done")
}
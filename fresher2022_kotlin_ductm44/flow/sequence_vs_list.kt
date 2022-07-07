package com.example.fresher2022_kotlin_ductm44.flow

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

suspend fun fooList(): List<Int> {
    val list = mutableListOf<Int>()
    for (i in 1..3) {
        delay(1000)
        list.add(i)
    }

    return list
}

fun fooSequence(): Sequence<Int> = sequence { // sequence builder
    for (i in 1..3) {
        Thread.sleep(1000)
        yield(i)
    }
}

fun main() = runBlocking {
    val time = measureTimeMillis {
        fooSequence().forEach { value -> println(value) }
    }
    println(time)
}

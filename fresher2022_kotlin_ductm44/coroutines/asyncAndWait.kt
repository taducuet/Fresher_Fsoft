package com.example.fresher2022_kotlin_ductm44.coroutines
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun printInt(): Int {
    return 10
}

suspend fun printOne(): Int {
    delay(1000L)
    return 10
}

suspend fun printTwo(): Int {
    delay(1000L)
    return 20
}

fun notUseAsync(){
    runBlocking {
        val time = measureTimeMillis {
            val one = printOne()
            val two = printTwo()
            println("The answer is ${one + two}")
        }
        println("Completed in $time ms")
    }
}

/*fun sumOfTwoJob(){
    runBlocking {
        val time = measureTimeMillis {
            val one = launch { printOne() }
            val two = launch { printTwo() }
            println("The answer is ${one + two}") // Error: Do coroutine trả về kiểu Job nên không thể tính tổng của 2 job
        }
        println("Completed in $time ms")
    }
}*/

fun testAsync(){
    runBlocking {
        //async được dùng để launch 1 coroutine như runBlocking, launch.
        //Nhưng trả về kiểu Deferred<Int>, Deferred<String>, Deferred<Unit>,...
        val int: Deferred<Int> = async { printInt() }
        val str: Deferred<String> = async { return@async "Sun" }
        val unit: Deferred<Unit> = async { }

        //await(): get return value
        println("Int = ${int.await()}")
        println("String = ${str.await()}")
    }
}

fun useAsync(){
    runBlocking {
        val time = measureTimeMillis {
            val one = async { printOne() }
            val two = async { printTwo() }
            println("The answer is ${one.await() + two.await()}")
        }
        println("Completed in $time ms")
    }
}

fun lazyAsync(){ //only run when call start()
    runBlocking {
        val time = measureTimeMillis {
            val one = async(start = CoroutineStart.LAZY) { printOne() }
            val two = async(start = CoroutineStart.LAZY) { printTwo() }
            one.start() // start the first one
            two.start() // start the second one
            println("The answer is ${one.await() + two.await()}")
        }
        println("Completed in $time ms")
    }
}

fun lazyAsyncWithoutStart(){ //Nếu chỉ gọi await mà không gọi start() thì chạy tuần tự không khác j so với không dùng async
    runBlocking {
        val time = measureTimeMillis {
            val one = async(start = CoroutineStart.LAZY) { printOne() }
            val two = async(start = CoroutineStart.LAZY) { printTwo() }
            println("The answer is ${one.await() + two.await()}")
        }
        println("Completed in $time ms")
    }
}

fun main(){
    useAsync()
}
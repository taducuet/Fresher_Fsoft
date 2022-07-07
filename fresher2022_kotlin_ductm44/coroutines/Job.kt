package com.example.fresher2022_kotlin_ductm44.coroutines

import kotlinx.coroutines.*

fun join(){
    runBlocking {
        val job = GlobalScope.launch { // launch a new coroutine and keep a reference to its Job
            delay(5000L)
            println("World!")
        }
        println("Hello,")
        job.join() // wait until child coroutine completes
        println("Kotlin")
    }
}
suspend fun test(){
    Thread.sleep(500L)
}

fun cancel(){
    runBlocking {
        val job = launch {
            repeat(1000){
                i -> println("I'm sleeping $i")
                test()
            }
        }
        delay(1300L)
        println("main: I'm tired of waiting!")
        job.cancel()
        println("main: Now I can quit.")
    }
}

fun immortal(){
    runBlocking {
        val job = launch {
            try {
                repeat(1000){ i ->
                    println("I'm sleeping $i")
                    delay(500L)
                }
            } finally {
                withContext(NonCancellable){
                    println("I'm running finally")
                    delay(1000L)
                    println("Non-cancellable")
                }
            }
        }
        delay(1300L)
        println("main: I'm tired of waiting!")
        job.cancel()
        println("main: Now i'm quit")
    }
}

fun cancelWithIsActive(){
    runBlocking {
        val startTime = System.currentTimeMillis()
        val job = launch(Dispatchers.Default) {
            var nextPrintTime = startTime
            var i = 0
            while (isActive) {   // Điều kiện i < 5 đã được thay bằng isActive để ngăn chặn coroutine khi nó đã bị hủy
                if (System.currentTimeMillis() >= nextPrintTime) {
                    println("job: I'm sleeping ${i++} ...")
                    nextPrintTime += 500L
                }
            }
        }
        delay(1300L) // delay a bit
        println("main: I'm tired of waiting!")
        job.cancel() // cancels the job
        println("main: Now I can quit.")
    }
}

fun cancelNotSuspendFunction(){
    runBlocking {
        val startTime = System.currentTimeMillis()
        val job = launch(Dispatchers.Default) {
            var nextPrintTime = startTime
            var i = 0
            while (i < 5) {
                if (System.currentTimeMillis() >= nextPrintTime) {
                    println("job: I'm sleeping ${i++} ...")
                    nextPrintTime += 500L
                }
            }
        }
        delay(1300L) // delay a bit
        println("main: I'm tired of waiting!")
        job.cancel() // cancels the job
        println("main: Now I can quit.")
    }
}

fun timeout(){
    runBlocking {
        withTimeout(1300L) {
            repeat(1000) { i ->
                println("I'm sleeping $i ...")
                delay(500L)
            }
        }
    }
}

fun timeoutOrNull(){
    runBlocking {
        val result = withTimeoutOrNull(1300L) {
            repeat(1000) { i ->
                println("I'm sleeping $i ...")
                delay(500L)
            }
            "Done" // will get cancelled before it produces this result
        }
        println("Result is $result")                // Biến result sẽ null
    }
}
fun main(){
    timeoutOrNull()
}

package com.example.fresher2022_kotlin_ductm44.coroutines
import kotlinx.coroutines.*

//launch 3 coroutine in one scope with context: Dispatchers.IO. async() and launch() are extensions of coroutine scope.
//Can not launch coroutine out range of coroutine scope
fun launchScope(){
    CoroutineScope(Dispatchers.IO).launch {
        launch {

        }
        launch {

        }
        async {

        }
    }
}

fun coroutineProperty(){
    runBlocking {
        launch {       // coroutine 1
            delay(200L)
            println("Task from runBlocking")   // line code 1
        }

        GlobalScope.launch { // coroutine 2   // scope 2
            launch {   // coroutine 3
                delay(500L)
                println("Task from nested launch") // line code 2
            }

            delay(100L)
            println("Task from coroutine scope") // line code 3
        }
        println("Coroutine scope is over") // line code 4
    }
}

fun cancelFatherCoroutine(){
    runBlocking {
        val request = launch {
            GlobalScope.launch {
                delay(100)
                println("job2: I am a child of the request coroutine")   // line code 1
                delay(1000)
                println("job2: I will not execute this line if my parent request is cancelled") // line code 2
            }
        }
        delay(500)
        request.cancel() // cancel processing of the request
        delay(1000)
        println("main: Who has survived request cancellation?") // line code 3
    }
}

fun globalScope(){
    runBlocking {
        val request = launch {
            // it spawns two other jobs, one with GlobalScope
            GlobalScope.launch {
                println("job1: GlobalScope and execute independently!")
                delay(1000)
                println("job1: I am not affected by cancellation")  // line code 1 này vẫn được in ra mặc dù bị delay 1000ms
            }
            // and the other inherits the parent context
            launch {
                delay(100)
                println("job2: I am a child of the request coroutine")
                delay(1000)
                println("job2: I will not execute this line if my parent request is cancelled")
            }
        }
        delay(500)
        request.cancel() // cancel processing of the request
        delay(1000) // delay a second to see what happens
        println("main: Who has survived request cancellation?")
    }
}
fun main(){
    globalScope()
}
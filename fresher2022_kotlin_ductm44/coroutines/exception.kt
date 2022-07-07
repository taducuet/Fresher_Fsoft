package com.example.fresher2022_kotlin_ductm44.coroutines

import kotlinx.coroutines.*
import java.io.IOException

fun launchException() {
    runBlocking {
        GlobalScope.launch {
            println("Throwing exception from launch")
            throw IndexOutOfBoundsException()
            println("Unreached")
        }
    }
}

fun asyncException() {
    runBlocking {
        val deferred = GlobalScope.async {
            println("Throwing exception from async")
            throw ArithmeticException()
            println("Unreached")
        }
        deferred.await()
    }
}

//Catch exception 1,2 times
fun catchException() {
    runBlocking {
        GlobalScope.launch {
            try {
                println("Throwing exception from launch")
                throw IndexOutOfBoundsException()
                println("Unreached")
            } catch (e: IndexOutOfBoundsException) {
                println("Caught IndexOutOfBoundsException")
            }
        }

        val deferred = GlobalScope.async {
            println("Throwing exception from async")
            throw ArithmeticException()
            println("Unreached")
        }
        try {
            deferred.await()
            println("Unreached")
        } catch (e: ArithmeticException) {
            println("Caught ArithmeticException")
        }
    }
}

//catch Exception 100 times
fun exceptionHandler() {
    runBlocking {
        val handler = CoroutineExceptionHandler { _, exception ->
            println("Caught $exception")
        }
        val job = GlobalScope.launch(handler) {
            throw AssertionError()
        }
        val deferred = GlobalScope.async(handler) {
            throw ArithmeticException() // Nothing will be printed, relying on user to call deferred.await()
        }
        joinAll(job, deferred)
    }
}

fun sumManyException(){
    runBlocking {
        val handler = CoroutineExceptionHandler { _, exception ->
            println("Caught $exception with suppressed ${exception.suppressed.contentToString()}")
        }
        val job = GlobalScope.launch(handler) {
            launch {
                try {
                    delay(Long.MAX_VALUE) // delay vô hạn
                } finally {
                    throw ArithmeticException()
                }
            }
            launch {
                try {
                    delay(Long.MAX_VALUE) // delay vô hạn
                } finally {
                    throw IndexOutOfBoundsException()
                }
            }
            launch {
                delay(100)
                throw IOException()
            }
            delay(Long.MAX_VALUE)
        }
        job.join()
    }
}

fun superVisionJob(){
    runBlocking {
        val supervisor = SupervisorJob()
        with(CoroutineScope(coroutineContext + supervisor)) {
            // launch the first child -- its exception is ignored for this example (don't do this in practice!)
            val firstChild = launch(CoroutineExceptionHandler { _, _ ->  }) {
                println("First child is failing")
                throw AssertionError("First child is cancelled")
            }
            // launch the second child
            val secondChild = launch {
                firstChild.join()
                // Cancellation of the first child is not propagated to the second child
                println("First child is cancelled: ${firstChild.isCancelled}, but second one is still active")
                try {
                    delay(Long.MAX_VALUE)
                } finally {
                    // But cancellation of the supervisor is propagated
                    println("Second child is cancelled because supervisor is cancelled")
                }
            }
            // wait until the first child fails & completes
            firstChild.join()
            println("Cancelling supervisor")
            supervisor.cancel()
            secondChild.join()
        }
    }
}

fun superVisorScope(){
    runBlocking {
        val handler = CoroutineExceptionHandler { _, exception ->
            println("Caught $exception")
        }
        supervisorScope {
            val first = launch(handler) {
                println("Child throws an exception")
                throw AssertionError()
            }
            val second = launch {
                delay(100)
                println("Scope is completing")
            }
        }
        println("Scope is completed")
    }
}

fun main() {
    superVisorScope()
}
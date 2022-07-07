package com.example.fresher2022_kotlin_ductm44.coroutines
import kotlinx.coroutines.*
fun main() {
    newSingleThreadContext("thread1").use { ctx1 ->
        // tạo một context là ctx1 chứ chưa launch coroutine.
        // ctx1 sẽ có 1 element là dispatcher quyết định coroutine sẽ chạy trên 1 thread tên là thread1
        println("ctx1 - ${Thread.currentThread().name}")

        newSingleThreadContext("thread2").use { ctx2 ->
            // tạo một context là ctx2 chứ vẫn chưa launch coroutine
            // ctx2 sẽ có 1 element là dispatcher quyết định coroutine sẽ chạy trên 1 thread tên là thread2
            println("ctx2 - ${Thread.currentThread().name}")

            // bắt đầu chạy coroutine với context là ctx1
            runBlocking(ctx1) {
                // coroutine đang chạy trên context ctx1 và trên thread thread1
                println("Started in ctx1 - ${Thread.currentThread().name}")

                // sử dụng hàm withContext để chuyển đổi context từ ctx1 qua ctx2
                withContext(ctx2) {
                    // coroutine đang chạy với context ctx2 và trên thread thread2
                    println("Working in ctx2 - ${Thread.currentThread().name}")
                }

                // coroutine đã thoát ra block withContext nên sẽ chạy lại với context ctx1 và trên thread thread1
                println("Back to ctx1 - ${Thread.currentThread().name}")
            }
        }

        println("out of ctx2 block - ${Thread.currentThread().name}")
    }

    println("out of ctx1 block - ${Thread.currentThread().name}")
}

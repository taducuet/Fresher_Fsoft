package com.example.fresher2022_kotlin_ductm44.coroutines

import kotlinx.coroutines.*
import kotlin.coroutines.coroutineContext

fun main() = runBlocking<Unit>{
    GlobalScope.launch(newSingleThreadContext("newSingleThreadContext")
            +CoroutineName("CoroutineName")
            +NonCancellable){
    }
}
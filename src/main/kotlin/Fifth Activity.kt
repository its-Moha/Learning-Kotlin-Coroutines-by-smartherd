package org.example

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {

    // each coroutine if its parent or child has its own CoroutineScope

//    println("runBollocking: $this")
//
//    launch {
//        println("launch: $this")
//
//        launch {
//            println("child Coroutine: $this")
//        }
//    }
//
//    async {
//        println("async: $this")
//    }

    println()
    // Dispatcher: Which tread will our coroutine will execute


    // this : coroutineScope instance
    // coroutineContext: CoroutineContext instance

    //without parameter: Confined [ Confined Dispatcher]

    launch {
        println("Coroutine 1: ${Thread.currentThread().name}")
        // without parameter, it will stay the same thread
        delay(1000)
        println("Coroutine 1 after delay: ${Thread.currentThread().name}")

    }

    //with parameter: Dispatcher.Default [ Similar to global scope]
    launch(Dispatchers.Default) {
        println("Coroutine 2: ${Thread.currentThread().name}")
        delay(1000)
        println("Coroutine 2 after delay: ${Thread.currentThread().name}")

    }


    //with parameter: Dispatcher.Unconfined  [ UnConfined Dispatcher]
    launch(Dispatchers.Unconfined) {
        println("Coroutine 3: ${Thread.currentThread().name}")
        delay(1000)
        println("Coroutine 3 after delay: ${Thread.currentThread().name}")

    }
}
package org.example

import kotlinx.coroutines.*

fun main() = runBlocking {// create a blocking coroutine


    println("Main Program Starts: ${Thread.currentThread()}")

    val job : Job = launch { // Thread t1: creates a non-blocking coroutine
        for (i in 0..500){
            println("$i.")
            delay(100)
        }
    }

    delay(1000) // let's print a few values before we cancel
    job.cancelAndJoin() // waits for the coroutine to finish

    println("Main Program Finishes: ${Thread.currentThread()}")

}


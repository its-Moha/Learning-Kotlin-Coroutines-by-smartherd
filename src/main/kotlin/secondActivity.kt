package org.example

import kotlinx.coroutines.*

fun main() = runBlocking {// create a blocking coroutine


    println("Main Program Starts: ${Thread.currentThread()}")

    val job : Job = launch(Dispatchers.IO) { // Thread t1: creates a non-blocking coroutine

        try {

        for (i in 0..500){
           // if (!isActive){ //     return@launch //break //  }
            print("$i.")
            delay(5)
           // Thread.sleep(1)
        }
            }catch (ex: CancellationException){
                println("\nException caught safely: ${ex.message}")
            }finally {
            withContext(NonCancellable) {


                delay(1000)
                println("\nChoose a resources in finally")
            }
        }


    }

    delay(100) // let's print a few values before we cancel
    job.cancel(CancellationException("my own crush massage"))
    job.join() // waits for the coroutine to finish

    println("Main Program Finishes: ${Thread.currentThread()}")

}


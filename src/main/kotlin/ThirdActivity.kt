package org.example

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

fun main() = runBlocking {

    println("Main Program Stars: ${Thread.currentThread()}")

    //Time out cancellation exception

    // withTimeOut trows exception
    // withTimeOutOrNull trows no exception


    val result: String? = withTimeoutOrNull(4000){

            for (i in 0..500){
                println("$i.")
                delay(500)
            }

        "i am done"

    }

    println(result)

    println("Main Program Finishes: ${Thread.currentThread()}")
}
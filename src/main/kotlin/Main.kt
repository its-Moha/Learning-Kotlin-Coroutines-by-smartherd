package org.example

import com.sun.source.util.Plugin
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.concurrent.thread


fun main() { // Executes on The main thread

    println("Main program starts: ${Thread.currentThread().name}")



    GlobalScope.launch { //creates a background coroutine that runs on the background thread
        println("Fake work 2 starts: ${Thread.currentThread().name}")
        delay(4000)
        println("Fake work 2 finishes: ${Thread.currentThread().name}")
    }

    // block the current main thread and wait for the coroutine to finish
    Thread.sleep(6000)

    println("Main Program Ends: ${Thread.currentThread().name}")
}





//when the user launches the app a default thread is created
// and that thread is Known as main thread, and it is the life
// of the application
// and its operation is to perform some operations,
// and we perform it in small operation like click of a button or ui interaction
// but if we run big operations like network,downloading or load image
// our main thread will be blocked and our app will freeze
//so we need a worker thread or a background thread but if you
// do five of them our device will run out of memory and our app will crash
// That is where coroutines come you will have one background thread
//to launch a coroutine with different coroutines
//they are lightweight threads and can run in parallel
//  coroutines != threads
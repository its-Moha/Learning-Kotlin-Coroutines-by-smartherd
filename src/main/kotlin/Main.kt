package org.example

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread


fun main() { // Executes on The main thread

    println("Main program starts: ${Thread.currentThread().name}")

    thread {
        println("Tread background work Starts : ${Thread.currentThread()}")
        Thread.sleep(1000)
        println("Tread background work Finishes : ${Thread.currentThread()}")
    }


    //Coroutine1
    GlobalScope.launch { //creates a background coroutine that runs on the background thread
        println("Fake work 2 starts: ${Thread.currentThread().name}")
        mySuspend(2000) // does not block which is it operating
        println("Fake work 2 finishes: ${Thread.currentThread().name}")
    }

    // block the current main thread and wait for the coroutine to finish
    //Coroutine2
    runBlocking { // creates a coroutine that blocks the current Main thread
        mySuspend(3000)
    }

    println("Main Program Ends: ${Thread.currentThread().name}")
}

suspend fun mySuspend(time:Long) {

    delay(time)

}




//A coroutine is a smart job that can pause and continue later
// without blocking everything.

// coroutine Builders are used for creating coroutines

//launch = fire and forget
//async = wait for result
//runBlocking = stop everything (bad)

//GlobalScope = creates coroutine at global(app) level
//e.g = file download/play music
//Why it’s BAD ❌
// Lives forever, Ignores screen lifecycle, Causes memory leaks, Can crash apps
//🚫 Never use in Android UI

//Launch = creates coroutine at local level
//e.g = login operation

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

//they are lightweight threads and can run in parallel wait for each other
//and communicate with each other

//  coroutines != threads

// with the memory conception of one thread using coroutines
// you can perform so many operations


// Thread.sleep function = it pauses the main thread and other threads
// delay = when the thread launches it attach coroutines to it
// so if we have five coroutines and one of them is paused the
// others will not be blocked

// function with " suspend " modifier is known as suspend function

//suspend function are only allowed to be called from
// a coroutine or another suspend function

// they cannot be called from outside a coroutine

//global Scope = creates a coroutine that does not block the main thread
// runBlocking = blocks the thread in which it operates
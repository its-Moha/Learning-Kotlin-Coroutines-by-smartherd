package org.example

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() = runBlocking {

    println("Main Program Starts: ${Thread.currentThread()}")

    // code with in a coroutine are sequentially by default
    /**
    Sequential execution means tasks happen one after another
    in a strict order, like a single-file line,
    with each step finishing before the next begins,

    while concurrent execution allows multiple tasks
    to make progress at the same time, overlapping their execution
    to improve efficiency, even if they aren't running simultaneously on different processors.
     */

    // these two codes were executed one after another so it's sequentially
    //The second task cannot start until the first one fully finishes
    //No overlap
    //One after another

    //

    val time = measureTimeMillis {
        val msgOne = getMessageOne()
        val msgTwo = getMessageTwo()

        println("The entire message: ${msgOne + msgTwo}")
    }

    println("Completed in $time ms")

    println()

    // these two codes were executed at the same time so its concurrent

    // async says: “Start this work now, don’t wait for the result yet.”
    // async does not make things faster by magic
    // It makes things faster because tasks overlap

    //await() means: “Give me the result when it’s ready”
    //If it’s already finished → returns instantly
    //If not → waits

    //async helps only when tasks are independent
    //getMessageOne() does not depend on getMessageTwo()
    //
    //Both only wait (delay)

    //Deferred<String> is a promise for a future String.
    // Not the String itself —
    //a container that will give you a String later.

    val time2 = measureTimeMillis {
        val msgOne: Deferred<String> = async {  getMessageOne()}
        val msgTwo: Deferred<String> = async {  getMessageTwo()}
        println("The entire message2: ${msgOne.await() + msgTwo.await()}")
    }


    /**
    One-sentence summary

    Time 1 is slower because each suspend function waits one after another.
    Time 2 is faster because async starts both tasks together and await
    only waits for the results, overlapping the waiting time.
     */


    // why did we use asyn and not launch?
    // sync returns a value
    // launch does not return a value




    println("Completed in $time2 ms")



    println("Main Program Finishes: ${Thread.currentThread()}")
}

suspend fun getMessageOne(): String{
    delay(1000L)  // pretend to do some work for one second
    return ("Hello")
}

suspend fun getMessageTwo(): String{
    delay(1000L)  // pretend to do some work for one second
    return (" World")
}
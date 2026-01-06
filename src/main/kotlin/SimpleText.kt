package org.example

import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class SimpleText {

    @Test

    fun myFirstTest() = runBlocking{
        mySuspend(
            time = 2000
        )
        Assert.assertEquals(10, 5 + 5)
    }
}
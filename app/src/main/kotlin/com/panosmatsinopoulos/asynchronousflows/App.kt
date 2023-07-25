/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package com.panosmatsinopoulos.asynchronousflows

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun simple(): Flow<Int> = flow {
    for (i in 1..3) {
        delay(100)
        log("emitting $i")
        emit(i)
    }
}

fun log(msg: String) {
    println("[${Thread.currentThread().name}] $msg")
}

fun main() {
    println("Main starting...")
    runBlocking {
        val time = measureTimeMillis {
            simple().conflate()
                .collect { value ->
                    delay(300)
                    log("collecting $value")
                }
        }
        println("collected in $time ms")
    }
    println("Main ending")
}

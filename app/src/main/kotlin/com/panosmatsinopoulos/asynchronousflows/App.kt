/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package com.panosmatsinopoulos.asynchronousflows

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun log(msg: String) {
    println("[${Thread.currentThread().name}] $msg")
}

fun requestFlow(i: Int): Flow<String> = flow {
    emit("$i: First")
    delay(500)
    emit("$i: Second")
}

@OptIn(ExperimentalCoroutinesApi::class)
fun main() {
    log("Main starting...")
    runBlocking {
        (1..3).asFlow()
            .flatMapConcat { i -> requestFlow(i) }
            .collect { value ->
                log("collecting $value")
            }
    }
    log("Main ending")
}

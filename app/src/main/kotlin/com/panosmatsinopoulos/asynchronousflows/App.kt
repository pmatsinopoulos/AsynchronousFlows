/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package com.panosmatsinopoulos.asynchronousflows

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

fun main() {
    println("Main starting...")
    runBlocking {
        (1..5).asFlow()
            .filter { it % 2 == 0 }
            .map { it.toString() }
            .collect { value -> println(value) }
    }
    println("Main ending")
}
